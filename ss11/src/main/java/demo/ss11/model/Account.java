package demo.ss11.model;

import demo.ss11.validator.ValidPassword;
import demo.ss11.validator.Validation.AdminGroup;
import demo.ss11.validator.Validation.UserGroup;
import lombok.Data;
import javax.validation.constraints.*;

@Data
public class Account {

    @NotBlank(message = "Tên không được để trống", groups = { AdminGroup.class, UserGroup.class})
    private String name;

    @NotBlank(message = "Email không được để trống", groups = {AdminGroup.class, UserGroup.class})
    @Email(message = "Email không đúng định dạng", groups = {AdminGroup.class, UserGroup.class})
    private String email;

    @NotBlank(message = "Vai trò không được để trống", groups = {AdminGroup.class, UserGroup.class})
    private String role;

    @NotBlank(message = "Mã xác minh admin là bắt buộc", groups = AdminGroup.class)
    private String adminCode;

    @ValidPassword
    private String password;
}
