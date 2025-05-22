package demo.ss11.model;

import demo.ss11.validator.ValidEmail;
import demo.ss11.validator.ValidPassword;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserB2 {

    @NotBlank(message = "Tên không được để trống")
    private String name;

    @ValidEmail
    private String email;

    @ValidPassword
    private String password;
}
