package demo.ss10.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String address;
}
