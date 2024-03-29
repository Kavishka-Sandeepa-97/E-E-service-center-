package dao.custom;

import dao.CrudDao;
import entity.Customer;
import entity.Item;

import java.sql.SQLException;

public interface ItemDao extends CrudDao<Item> {
//    boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException;
//    boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException;
//    boolean deleteItem(String id) throws SQLException, ClassNotFoundException;
//    List<ItemDto> allItem() throws SQLException, ClassNotFoundException;
//    ItemDto getItem(String id) throws SQLException, ClassNotFoundException;
    Item getItem(String id)  ;
    Item lastItem();
}
