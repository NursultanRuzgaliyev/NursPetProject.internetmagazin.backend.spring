package kz.ruzgaliyev.internetmagazin.controller;

import kz.ruzgaliyev.internetmagazin.requestDto.UserChangePasswordDto;
import kz.ruzgaliyev.internetmagazin.requestDto.UserCreateDto;
import kz.ruzgaliyev.internetmagazin.requestDto.UserSignInDto;
import kz.ruzgaliyev.internetmagazin.serviceImpl.KeycloakService;
import kz.ruzgaliyev.internetmagazin.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor

public class UserController {

    private final KeycloakService keycloakService;

    @PostMapping(value = "/create")
    public UserRepresentation createUser(@RequestBody UserCreateDto userCreateDto) {
        return keycloakService.createUser(userCreateDto);
    }
    @PostMapping(value = "/sign-in")
    public String signIn(@RequestBody UserSignInDto userSignInDto) {
        return keycloakService.signIn(userSignInDto);
    }
    @PostMapping(value = "/change-password")
    public ResponseEntity<String> changePassword(@RequestBody UserChangePasswordDto userChangePasswordDto){
        String currentUsername = UserUtils.getCurrentUsername();
        if(currentUsername == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Couldnt identify user");
        }
        try {
            keycloakService.changePassword(currentUsername, userChangePasswordDto.newPassword);
            return ResponseEntity.ok("Password changed");
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
