package kz.ruzgaliyev.internetmagazin.responseDto;

import lombok.*;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String fullName;
    private String email;
    private Set<String> roles;
}
