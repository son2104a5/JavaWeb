package demo.ss08.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGame {
    private int id;
    private String username;
    private String password;
    private String email;
    private double balance = 10000;
}
