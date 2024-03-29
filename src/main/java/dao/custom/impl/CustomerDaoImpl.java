package dao.custom.impl;

import dao.custom.CustomerDao;

import dao.util.HibernateUtil;
import dto.CustomerDto;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean save(Customer entity){

//        Configuration configuration = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Customer.class);
//        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session= HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
//        String sql = "insert into customer values('" + entity.getCustId() + "','" + entity.getCustName() + "','" + entity.getCustAddress()+ "'," + entity.getSalary() + ")";
//
//        Connection conn = DBConnection.getInstance().getConnection();
//        Statement stm = conn.createStatement();
//        int res = stm.executeUpdate(sql);
//        return res>0 ? true :false;
    }

    @Override
    public boolean delete(String value)  {


        Session session= HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();

        Customer customer=session.find(Customer.class,value);

        session.delete(customer);
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(Customer entity) {

//
//        Session session=HibernateUtil.getSession();
//        Transaction transaction=session.beginTransaction();
//
//        Customer customer=session.find(Customer.class,entity.getCustId());
//
//        customer.setCustName(entity.getCustName());
//        customer.setSalary(entity.getSalary());
//        customer.setCustAddress(customer.getCustAddress());
//
//        session.save(customer);
//        transaction.commit();
//        return true;

//----------------------------------------------------------------------------------------
//        String sql = "update Customer set custName='" + entity.getCustName() + "'," + "custAddress='" + entity.getCustAddress() + "'," + "Salary=" + entity.getSalary() + " where custid='" + entity.getCustId() + "'";
//        Connection conn = DBConnection.getInstance().getConnection();
//        Statement stm = conn.createStatement();
//        int res = stm.executeUpdate(sql);
//        if (res>0)return true;
//        return false;
        return true;
    }

    @Override
    public List<Customer> getAll(){

            Session session=HibernateUtil.getSession();
        Query fromCustomer = session.createQuery("From Customer");
        List list = fromCustomer.list();
        return list;
//        List<Customer> list=new ArrayList<>();
//        String sql = "select * from customer";
//
////        Connection conn= DBConnection.getInstance().getConnection();
////        PreparedStatement pstm= conn.prepareStatement(sql);
//        ResultSet rst = CrudUtil.exicute(sql);
//        while (rst.next()){
//            list.add(new Customer(
//                    rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getDouble(4)
//            ));
//
//        }
//        return list;
    }

    @Override
    public Customer lastOrder() {
        Customer lastRow=null;
        Session session=HibernateUtil.getSession();
        Query<Customer> query = session.createQuery("FROM Customer ORDER BY customerID DESC", Customer.class);

        query.setMaxResults(1);
        lastRow = query.uniqueResult();
        return lastRow;
    }
}