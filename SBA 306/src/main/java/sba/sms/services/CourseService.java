package sba.sms.services;

import jakarta.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sba.sms.dao.CourseI;
import sba.sms.models.Course;
import sba.sms.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * CourseService is a concrete class. This class implements the
 * CourseI interface, overrides all abstract service methods and
 * provides implementation for each method.
 */
public class CourseService implements CourseI {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @Override
    public void createCourse(Course course){
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(course);
        session.getTransaction().commit();
    }

    @Override
    public Course getCourseById(int courseId){

        Session session = factory.openSession();
        String hqlQuery = "SELECT c FROM Course c WHERE c.id = :courseId";

        TypedQuery<Course> query = session.createQuery(hqlQuery, Course.class);
        query.setParameter("courseId", courseId);

        try{
            Course result = query.getSingleResult();
            return result;
        }catch(Exception e){
            return null;
        }finally{
            session.close();
        }

    }

    @Override
    public List<Course> getAllCourses(){
        Session session = factory.openSession();
        String hqlQuery = "SELECT c FROM Course c ";

        TypedQuery<Course> query = session.createQuery(hqlQuery, Course.class);

        try{
            return query.getResultList();
        }catch(Exception e){
            return null;
        }finally{
            session.close();
        }

    }

}
