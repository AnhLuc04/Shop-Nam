package Login.Mangger;

import Login.model.User;

import java.sql.*;

public class UserDao implements  Users {
    public  String jdbcURL="jdbc:mysql://localhost:3306/User?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "04032001";

    private static final String INSERT_USER_SQL = "INSERT INTO user" + "  (username,password) VALUES " +
            " (?, ?);";
    private DriverManager connection;

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("kết nối oke");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("kết nối ko oke");
// ĐỂ LÀM khối bắt tự động
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("kết nối ko oke");
// ĐỂ LÀM khối bắt tự động7
        }
        return connection;
    }

    @Override
    public User Login(String name) {
        String sql = "SELECT * FROM  user WHERE name = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String u = rs.getString(1);
                String p = rs.getString(2);
                int role = rs.getInt(3);

                return new  User(u, p, role);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi thực thi lệnh SQL SELECT");
        }
        return null;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USER_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
           throw  new  SQLException(e);
        }
    }

    public static void main(String[] args) {
        UserDao userDao= new UserDao();
        userDao.getConnection();
    }
}
