package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import static by.itclass.constants.DBConstant.*;

public class UserDao {
    private static final String SELECT_USER = "Select id,name,email From user where login = ? And password = ?";
    private static final String INSERT_USER = "Insert Into user(name,email,login,password) Values(?,?,?,?)";
    private static final String SELECT_USER_BY_LOGIN = "Select id From user where login = ?";
    private static UserDao dao;

    private UserDao() {
        ConnectionManager.init();
    }

    public static UserDao getInstance() {
        if (Objects.isNull(dao)) {
            dao = new UserDao();
        }
        return dao;
    }

    public User selectUser(String login, String password) {
        try (var cn = ConnectionManager.getConnection();
             var ps = cn.prepareStatement(SELECT_USER)) {
            ps.setString(1, login);
            ps.setString(2, password);
            var rs = ps.executeQuery();
            if (rs.next()) {
                var id = rs.getInt(ID_COL);
                var name = rs.getString(NAME_COL);
                var email = rs.getString(EMAIL_COL);
                return new User(id, name, email, login, password.toCharArray());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertUser(User user) {
        try (var cn = ConnectionManager.getConnection();
             var psInsert = cn.prepareStatement(INSERT_USER);
             var psCheck = cn.prepareStatement(SELECT_USER_BY_LOGIN)) {
            psCheck.setString(1, user.getLogin());
            if (isAccessible(psCheck)) {
                psInsert.setString(1, user.getName());
                psInsert.setString(2, user.getEmail());
                psInsert.setString(3, user.getLogin());
                psInsert.setString(4, String.valueOf(user.getPassword()));
                return psInsert.executeUpdate() == 1;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private boolean isAccessible(PreparedStatement ps) throws SQLException {
        return !ps.executeQuery().next();
    }
}
