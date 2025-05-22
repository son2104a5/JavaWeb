package demo.ss11.model;

import demo.ss11.validator.ValidPhone;
import lombok.Data;
import javax.validation.constraints.*;

@Data
public class UserB1 {

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 30, message = "Tên phải từ 2 đến 30 ký tự")
    private String name;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @ValidPhone
    private String phone;

    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;

    private boolean status;
}
