package Mangger;

import model.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDao implements ShopDaoInterface {

    private String jdbcURL = "jdbc:mysql://localhost:3306/Shop?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "04032001";

    private static final String INSERT_shop_SQL = "INSERT INTO shop" + "  (url,name,price,Description) VALUES " + " (?, ?, ?,?);";
    private static final String SELECT_Shop_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_FROM_SHOP = "select * from shop";
    private static final String DELETE_Shop_SQL = "delete from shop where id = ?;";
    private static final String UPDATE_Shop_SQL = "update shop set name = ?,url=?,price= ?,Description =? where id = ?;";
    private static final String SEARCH_BY_COUNTRY =  "select * from shop where country like ?;";
    private static final String SORT_BY_NAME =  "select * from shop order by name";
    ;

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("kết nối oke");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
// ĐỂ LÀM khối bắt tự động
        } catch (SQLException throwables) {
            throwables.printStackTrace();
// ĐỂ LÀM khối bắt tự động7
        }
        return connection;
    }

    @Override
    public List<Shop> selectShop() {
        //b1 :thiết lập kết nối
        List<Shop> shops = new ArrayList<>();
// Bước 2: Tạo câu lệnh bằng cách sử dụng đối tượng kết nối
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_SHOP);) {
            System.out.println(preparedStatement);
            // Bước 3: Thực hiện truy vấn hoặc cập nhật truy vấn
            ResultSet rs = preparedStatement.executeQuery();
// Bước 4: Xử lý đối tượng resultset.
            while (rs.next()) {
                int id = rs.getInt("id");
                String url=rs.getString("url");
                String name = rs.getString("name");
                String price = rs.getString("price");
                String Description = rs.getString("Description");
                shops.add(new Shop(id,url, name, price, Description));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shops;
    }

    @Override
    public void insertShop(Shop shop) throws SQLException {
        System.out.println(INSERT_shop_SQL);
        // câu lệnh try-with-resource sẽ tự động đóng kết nối.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_shop_SQL)) {

            preparedStatement.setString(1,shop.getUrl());
            preparedStatement.setString(2, shop.getName());
            preparedStatement.setString(3,shop.getPrice());
            preparedStatement.setString(4, shop.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            new SQLException(e);
        }
    }

    @Override
    public boolean updateShop(Shop shop) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement Statement = connection.prepareStatement(UPDATE_Shop_SQL)) {
            Statement.setString(1,shop.getUrl());
            Statement.setString(2, shop.getName());
            Statement.setString(3, shop.getPrice());
            Statement.setString(4,shop.getDescription());
            Statement.setInt(5,shop.getId());
            rowUpdated = Statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteShop(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_Shop_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Shop> findByCountry(String country) throws SQLException {
        List<Shop> shops = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = (PreparedStatement) connection.prepareStatement(SEARCH_BY_COUNTRY);
        ) {
            statement.setString(1, "%" + country + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String url=resultSet.getString("url");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String Description = resultSet.getString("Description");
                shops.add(new Shop(id,url, name,price , Description));
            }
        }
        return shops;
    }

    @Override
    public List<Shop> sort() throws SQLException {
        List<Shop> shops = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = (PreparedStatement) connection.prepareStatement(SORT_BY_NAME);
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String url = resultSet.getString("url");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String Description= resultSet.getString("Description");
                shops.add(new Shop(id,url, name, price, Description));
            }
        }
        return shops;

    }

    public static void main(String[] args) {
        ShopDao shopDao = new ShopDao();
        shopDao.getConnection();
    }
}