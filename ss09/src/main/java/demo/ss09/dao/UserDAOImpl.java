package demo.ss09.dao;

import demo.ss09.model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static demo.ss09.utils.ConnectionDB.getConnection;

public class UserDAOImpl implements UserDAO {
    @Override
    public User checkLogin(String username, String password) {
        String sql = "CALL check_is_user(?, ?)"; // gọi stored procedure
        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, username);
            cs.setString(2, password);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
