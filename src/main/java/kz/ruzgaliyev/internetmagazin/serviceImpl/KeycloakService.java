package kz.ruzgaliyev.internetmagazin.serviceImpl;

import kz.ruzgaliyev.internetmagazin.requestDto.UserCreateDto;
import kz.ruzgaliyev.internetmagazin.requestDto.UserSignInDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeycloakService {
    private final Keycloak keycloak;
    private final RestTemplate restTemplate;
    @Value("${keycloak.url}")
    private String url;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client}")
    private String client;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    public UserRepresentation createUser(UserCreateDto user) {
        UserRepresentation newUser = new UserRepresentation();
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEnabled(true);

        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(user.getPassword());
        credential.setTemporary(false);

        newUser.setCredentials(List.of(credential));

        try {
            Response response = keycloak
                    .realm(realm)
                    .users()
                    .create(newUser);

            if (response.getStatus() != HttpStatus.CREATED.value()) {
                String error = response.readEntity(String.class);
                log.error("Failed to create user. Status: {}. Response: {}", response.getStatus(), error);
                throw new RuntimeException("Failed to create user: " + error);
            }

            List<UserRepresentation> searchUsers = keycloak.realm(realm).users().search(user.getUsername());
            if (searchUsers.isEmpty()) {
                throw new RuntimeException("User created but not found in search");
            }
            return searchUsers.get(0);

        } catch (Exception e) {
            log.error("Exception while creating user in Keycloak", e);
            throw new RuntimeException("Exception while creating user in Keycloak: " + e.getMessage(), e);
        }

    }
    public String signIn(UserSignInDto userSignInDto) {
        String tokenEndpoint = url + "/realms/" + realm + "/protocol/openid-connect/token";
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "password");
        formData.add("client_id", client);
        formData.add("client_secret", clientSecret);
        formData.add("username", userSignInDto.getUsername());
        formData.add("password", userSignInDto.getPassword());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        ResponseEntity<Map> response = restTemplate.postForEntity(tokenEndpoint,new HttpEntity<>(formData,headers),Map.class);
        Map<String,Object> responseBody = response.getBody();
        if (!response.getStatusCode().is2xxSuccessful() || responseBody == null) {
            log.error("Error on signing in!");
            throw new RuntimeException("Failed to authenticated!");
        }
        return (String) responseBody.get("access_token");
    }
    public void changePassword(String username,String newPassword) {
        List<UserRepresentation> users = keycloak
                .realm(realm)
                .users()
                .search(username);
        if(users.isEmpty()) {
            log.error("User not found");
            throw new RuntimeException("User not found");
        }
        UserRepresentation userRepresentation = users.get(0);

        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(newPassword);
        credential.setTemporary(false);

        keycloak
                .realm(realm)
                .users()
                .get(userRepresentation.getId())
                .resetPassword(credential);
        log.info("Changed password");

    }
}