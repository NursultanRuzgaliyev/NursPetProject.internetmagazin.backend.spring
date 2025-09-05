package kz.ruzgaliyev.internetmagazin.requestDto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserCreateDto {
    private String email;
    private boolean emailVerified;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
}
