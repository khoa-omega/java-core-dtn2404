package repository;

import entity.User;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public List<User> findAll() throws SQLException {
        String sql = "SELECT * FROM users";
        try (
                Connection connection = JdbcUtil.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setProSkill(rs.getString("pro_skill"));
                user.setExpInYear(rs.getInt("exp_in_year"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
            return users;
        }
    }
}
