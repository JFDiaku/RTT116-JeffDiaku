package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDetailDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void UpdateOrderDetail(OrderDetail orderDetail) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        //use merge instead of persist when updating
        // product must already exist to update unless, error
        session.merge(orderDetail);
        session.getTransaction().commit();
    }

    public void createOrder(OrderDetail orderDetail) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(orderDetail);
        session.getTransaction().commit();
    }

    public void deleteOrderDetail(OrderDetail orderDetail) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.detach(orderDetail);
        session.getTransaction().commit();
    }

    public OrderDetail findOrderDetailById(Integer id){
        String hqlQuery = "SELECT o from OrderDetail o WHERE o.id = :id";

        Session session = factory.openSession();

        TypedQuery<OrderDetail> query = session.createQuery(hqlQuery, OrderDetail.class);
        query.setParameter("id", id);

        try{
            return query.getSingleResult();
        }catch(Exception e){
            return null;
        }finally {
            session.close();
        }
    }
}
