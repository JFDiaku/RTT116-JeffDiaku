package org.example.database.dao;


import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.example.database.entity.Order;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void UpdateOrder(Order order) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        //use merge instead of persist when updating
        // product must already exist to update unless, error
        session.merge(order);
        session.getTransaction().commit();
    }

    public void createOrder(Order order) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(order);
        session.getTransaction().commit();
    }

    public void deleteOrder(Order order) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.detach(order);
        session.getTransaction().commit();
    }

    public Order findOrderById(Integer id){
        String hqlQuery = "SELECT o from Order o WHERE o.id = :id";

        Session session = factory.openSession();

        TypedQuery<Order> query = session.createQuery(hqlQuery, Order.class);
        query.setParameter("id", id);

        try{
            return query.getSingleResult();
        }catch(Exception e){
            return null;
        }finally {
            session.close();
        }
    }

//    1)   Using the OrderDAO only!!! show me a list of products in a specific order id.     Only can use ...
//    orderDAO.findById();   After that you should be able to get the list of order details using java / hibernate
//    and loop over the order details and system.out.println the product
public List<Product> findProductsInOrder(Integer orderId) {
    String hqlQuery = "SELECT p FROM OrderDetail od, Product p WHERE od.order.id = :orderId AND od.product.id = p.id";
    Session session = factory.openSession();
    TypedQuery<Product> query = session.createQuery(hqlQuery,Product.class);
    query.setParameter("orderId",orderId);

    try {
        List<Product> result = query.getResultList();
        return result;
    } catch ( Exception e ) {
        return new ArrayList<>();
    } finally {
        session.close();
    }
}






}
