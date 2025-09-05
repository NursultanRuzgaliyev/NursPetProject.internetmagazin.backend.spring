package kz.ruzgaliyev.internetmagazin.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserChangePasswordDto {

    public String newPassword;
}
