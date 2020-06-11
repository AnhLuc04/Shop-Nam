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
    private static final String SELECT_FROM_SHOP = "select * from shop";
    private static final String DELETE_Shop_SQL = "delete from shop where id = ?;";
    private static final String UPDATE_Shop_SQL = "update shop set name = ?,url=?,price= ?,Description =? where id = ?;";
    private static final String SEARCH_BY_COUNTRY =  "select * from shop where name like ?;";
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
            System.out.println("kết nối ko oke");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("kết nối ko oke");
        }
        return connection;
    }

    @Override
    public List<Shop> selectShop() {
        List<Shop> shops = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_SHOP);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
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
    public List<Shop> SelectShop(int id) {
        List<Shop> shops = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_SHOP);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("id");
                String url=rs.getString("url");
                String name = rs.getString("name");
                String price = rs.getString("price");
                String Description = rs.getString("Description");
                shops.add(new Shop(ID,url, name, price, Description));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return shops;
    }

    @Override
    public void insertShop(Shop shop) throws SQLException {
        System.out.println(INSERT_shop_SQL);
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
    public List<Shop> findByCountry(String Name) throws SQLException {
        List<Shop> shop = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = (PreparedStatement) connection.prepareStatement(SEARCH_BY_COUNTRY);
        ) {
            statement.setString(1, "%" + Name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String url=resultSet.getString("url");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String Description = resultSet.getString("Description");
                shop.add(new Shop(id,url, name,price , Description));
            }
        }
        return shop;
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
}