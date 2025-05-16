package demo.ss09.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Customer {
    private Long id;
    private String username;
    private String phone;
    private String address;
    private String email;
    private String gender;
}
