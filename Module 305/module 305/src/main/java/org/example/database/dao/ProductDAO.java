package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public Product findById(Integer id){
        // Hibernate queries must use the java names from the entites
        // this is HQL
        String hqlQuery = "SELECT p FROM Product p WHERE p.id = :productId";
        // this is what is called native SQL - the native query only included here to show the difference
        // between HQL and native
        //String nativeSqlQuery = "select * from products where id = ?";

        // this is needed to get the database connection and let hibernate run the query
        Session session = factory.openSession();

        // hibernate uses this typed query to execute the query and fill "hydrate" the entity with the data from the database
        // passing in the HQL query and setting the datatype for hibernate to use
        TypedQuery<Product> query = session.createQuery(hqlQuery, Product.class);

        // now we can set the parameter on the query
        // the int id is the value that we want to substitute into the query at the
        // :productId location
        query.setParameter("productId", id);

        // we know this is a primary key so this query will return 0 recrods or 1 record
        // if the product was not found in the database we want to return null from our function
        // otherwise we want to return our product
        // hibernate will run the query and create a new product entity and fill it up with the data for us
        try {
            Product result = query.getSingleResult();
            return result;
        } catch ( Exception e ) {
            // no result was found .. for any number of reasons
            return null;
        } finally {
            // have to close the session at the end .. which tells hibernate to give the connection back to the pool
            session.close();
        }
    }

    public void createProduct(Product product){
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(product);
        session.getTransaction().commit();
    }


    public void updateProduct(Product product) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        //use merge instead of persist when updating
        // product must already exist to update unless, error
        session.merge(product);
        session.getTransaction().commit();
    }


    public List<Product> search(String name) {
        // WARNING !!!! HQL when doing a like statement needs special care in using some other method of concatinating the wild cards
        // into the query
        String hqlQuery = "SELECT p FROM Product p WHERE p.productName LIKE concat('%',:name,'%') order by p.buyPrice";

        Session session = factory.openSession();

        TypedQuery<Product> query = session.createQuery(hqlQuery, Product.class);
        query.setParameter("name", name);

        // will always return a list
        try {
            List<Product> result = query.getResultList();
            return result;
        } catch ( Exception e ) {
            // if an error happens
            // we should do some real error checking here
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public List<OrderDetail> findOrdersWithProduct(Integer productId) {
        String hqlQuery = "SELECT o from OrderDetail o WHERE o.product_id = :productId";

        Session session = factory.openSession();

        TypedQuery<OrderDetail> query = session.createQuery(hqlQuery, OrderDetail.class);
        query.setParameter("productId", productId);

        // will always return a list
        try {
            List<OrderDetail> result = query.getResultList();
            return result;
        } catch ( Exception e ) {
            // if an error happens
            // we should do some real error checking here
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }



}
