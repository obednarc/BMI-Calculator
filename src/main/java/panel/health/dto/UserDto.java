package panel.health.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserDto {

    @NotBlank(message = "*Nazwa użytkownika nie może być pusta.")
    private String username;

    @NotBlank(message = "*Hasło nie może być puste.")
    private String password;
}
