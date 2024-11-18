package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Product;
import org.example.database.entity.ProductLine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ProductLineDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public ProductLine findById(Integer id){
        String hqlQuery = "SELECT p FROM ProductLine p WHERE p.id = :id";

        Session session = factory.openSession();

        TypedQuery<ProductLine> query = session.createQuery(hqlQuery, ProductLine.class);
        query.setParameter("id", id);

        // will always return a list
        try {
            ProductLine result = query.getSingleResult();
            return result;
        } catch ( Exception e ) {
            // if an error happens
            // we should do some real error checking here
            return null;
        } finally {
            session.close();
        }

    }
}
