package Common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class UserRegisterDto {

    private String email;
    private String password;
    private String role;

    public static UserRegisterDto newUser() {
        String email = "admin@wallbox.com";
        String password = "admin1234";
        String role = "admin";
        return new UserRegisterDto(email, password, role);
    }


}
