package kz.ruzgaliyev.internetmagazin.responseDto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserResponseDto {
    private Long id;
    private String email;
    private boolean emailVerified;
    private String username;
    private String firstName;
    private String lastName;

}
