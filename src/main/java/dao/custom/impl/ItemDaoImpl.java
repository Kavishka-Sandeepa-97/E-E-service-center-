package dao.custom.impl;

import dao.custom.ItemDao;
import dao.util.HibernateUtil;
import entity.Customer;
import entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;

import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item entity) {
        Session session= HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String value){
        return false;
    }

    @Override
    public boolean update(Item entity) {
        return false;
    }

    @Override
    public List<Item> getAll() {
        Session session=HibernateUtil.getSession();
        Query fromCustomer = session.createQuery("From Item");
        List list = fromCustomer.list();
        return list;
    }

    @Override
    public Item getItem(String id)  {
        return null;
    }
    public Item lastItem() {
        Item lastRow=null;
        Session session= HibernateUtil.getSession();
        Query<Item> query = session.createQuery("FROM Item ORDER BY ItemCode DESC", Item.class);

        query.setMaxResults(1);
        lastRow = query.uniqueResult();
        return lastRow;
    }


//    @Override
//    public Item getItem(String id) throws SQLException, ClassNotFoundException {
//        String sql="select * from item where itemCode=?";
//
//        Connection conn=DBConnection.getInstance().getConnection();
//        PreparedStatement pstm=conn.prepareStatement(sql);
//        pstm.setString(1,id);
//
//        ResultSet resultSet = pstm.executeQuery();
//        if(resultSet.next()){
//           return new Item(
//                    resultSet.getString(1),
//                    resultSet.getString(2),
//                    resultSet.getDouble(3),
//                    resultSet.getInt(4)
//            );
//        }
//        return null;
//    }
//
//
//    @Override
//    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
//        String sql = "insert into item values(?,?,?,?)";
//
//        return CrudUtil.exicute(sql,entity.getItemCode(),entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand());
//
//    }
//
//    @Override
//    public boolean delete(String value) throws SQLException, ClassNotFoundException {
//        String sql = "delete  from Item  where  itemCode= ?";
//        return  CrudUtil.exicute(sql,value);
//
//    }
//
//    @Override
//    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
//        String sql = "UPDATE Item SET Description=?, UnitPrice=?, qtyOnHand=? WHERE itemCode=?";
//        return CrudUtil.exicute(sql,entity.getDescription(),String.valueOf(entity.getUnitPrice()),String.valueOf(entity.getQtyOnHand()),entity.getItemCode());
//
//    }
//
//    @Override
//    public List<Item> getAll() throws SQLException, ClassNotFoundException {
//        List<Item> list=new ArrayList<>();
//        String sql="select*from Item";
//
//        ResultSet resultSet = CrudUtil.exicute(sql);
//
//        while (resultSet.next()){
//            list.add(new Item(
//                    resultSet.getString(1),
//                    resultSet.getString(2),
//                    resultSet.getDouble(3),
//                    resultSet.getInt(4)
//            ));
//        }
//        return list;
//    }
}
