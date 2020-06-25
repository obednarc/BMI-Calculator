package panel.health.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "*Nazwa użytkownika nie może być pusta.")
    private String username;

    @NotEmpty(message = "*Hasło nie może być puste.")
    private String password;

    private String firstName;
    private String lastName;
    private String email;

    @Pattern(regexp="(^$|[0-9]{9})", message = "*Numer telefonu musi składać się z maxymalnie 9 cyfr.")
    private String phone;
}
