package demo.ss10.repository;

import demo.ss10.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountDao {
    private Connection connection;

    public AccountDao(Connection connection) {
        this.connection = connection;
    }

    public void save(Account account) {
        String sql = "INSERT INTO accounts(username, password, email) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
