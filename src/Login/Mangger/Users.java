package Login.Mangger;

import Login.model.User;

import java.sql.SQLException;

public interface Users {
    public User Login(String name);
    public void insertUser(User user) throws SQLException;
}
