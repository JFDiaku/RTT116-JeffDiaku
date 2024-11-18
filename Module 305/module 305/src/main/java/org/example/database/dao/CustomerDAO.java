package org.example.database.dao;


import org.hibernate.SessionFactory;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public void UpdateCustomer(Customer customer) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        //use merge instead of persist when updating
        // product must already exist to update unless, error
        session.merge(customer);
        session.getTransaction().commit();
    }

    public void createCustomer(Customer customer) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(customer);
        session.getTransaction().commit();
    }



    public void deleteCustomer(Customer customer) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.detach(customer);
        session.getTransaction().commit();
    }

    public Customer findCustomerById(Integer id){

        Session session = factory.openSession();
        String hqlQuery = "SELECT c FROM Customer c WHERE c.id = :customerId";

        TypedQuery<Customer> query = session.createQuery(hqlQuery, Customer.class);
        query.setParameter("customerId", id);

        try{
            Customer result = query.getSingleResult();
            return result;
        }catch(Exception e){
            return null;
        }finally{
            session.close();
        }
    }

    public List<Customer> findCustomerWithName(String name) {
        Session session = factory.openSession();

        String hqlName = "SELECT c FROM Customer c WHERE c.contact_firstname = :cName " +
                "                                   OR c.customer_name = :cName" +
                "                                   OR c.contact_lastname = :cName" +
                "                                   ORDER BY c.contact_firstname";

        TypedQuery<Customer> query = session.createQuery(hqlName, Customer.class);
        query.setParameter("cName", name);

        try{
            List<Customer> resultNameList = query.getResultList();
            return resultNameList;
        }catch(Exception e) {
            return new ArrayList<>();

        }finally {
            session.close();
        }

    }


}
