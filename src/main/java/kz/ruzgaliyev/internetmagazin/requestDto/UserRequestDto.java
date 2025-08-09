package kz.ruzgaliyev.internetmagazin.requestDto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {
    private String fullName;
    private String email;
    private String password;
}
