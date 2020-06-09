package Mangger;

import model.Shop;

import java.sql.SQLException;
import java.util.List;

public interface ShopDaoInterface {
   public List<Shop> selectShop();
   public  void insertShop(Shop shop) throws SQLException;
   public boolean updateShop(Shop shop) throws  SQLException;
   public boolean deleteShop(int id) throws SQLException;
   List<Shop> findByCountry(String country) throws SQLException;
   List<Shop> sort() throws SQLException;
}
