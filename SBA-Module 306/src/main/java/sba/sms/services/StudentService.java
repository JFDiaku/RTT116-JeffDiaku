package sba.sms.services;

import jakarta.persistence.TypedQuery;
import lombok.extern.java.Log;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import sba.sms.dao.StudentI;
import sba.sms.models.Course;
import sba.sms.models.Student;
import sba.sms.models.StudentCourse;
import sba.sms.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * StudentService is a concrete class. This class implements the
 * StudentI interface, overrides all abstract service methods and
 * provides implementation for each method. Lombok @Log used to
 * generate a logger file.
 */

public class StudentService implements StudentI {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @Override
    public List<Student> getAllStudents(){
        String hqlQuery = "SELECT s from Student s ";

        Session session = factory.openSession();

        TypedQuery<Student> query = session.createQuery(hqlQuery, Student.class);

        try{
            return query.getResultList();
        }catch(Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public void createStudent(Student student){
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(student);
        session.getTransaction().commit();
    }

    @Override
    public Student getStudentByEmail(String email){
        String hqlQuery = "SELECT S from Student s WHERE s.email = :email OR s.email LIKE :email";

        Session session = factory.openSession();

        TypedQuery<Student> query = session.createQuery(hqlQuery, Student.class);
        query.setParameter("email", email);

        try{
            return query.getSingleResult();
        }catch(Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean validateStudent(String email, String password){
        String hqlQuery = "SELECT S from Student s WHERE s.email = :email AND s.password = :password";
        Session session = factory.openSession();

        TypedQuery<Student> query = session.createQuery(hqlQuery, Student.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        try{
            Student result = query.getSingleResult();
            return true;
        }catch(Exception e){
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public void registerStudentToCourse(String email, int courseId){
        Student student = getStudentByEmail(email);
        String hqlQuery = "SELECT c from Course c WHERE c.id = :courseId";

        Session session = factory.openSession();

        TypedQuery<Course> query = session.createQuery(hqlQuery, Course.class);
        query.setParameter("courseId", courseId);

        Course course = null;
        try{
            course = query.getSingleResult();
        }catch(Exception e){
            System.out.println(e);
        }

        StudentCourseService studentCourseService = new StudentCourseService();

        StudentCourse studentCourse = new StudentCourse();

        studentCourse.setCourse(course);
        studentCourse.setStudent(student);

        studentCourseService.createStudentCourse(studentCourse);
    }

    @Override
    public List<Course> getStudentCourses(String email){
        Student student = getStudentByEmail(email);

        int id = student.getId();

        String hqlQuery = "SELECT c from Course c, StudentCourse sc WHERE sc.student = :id";

        Session session = factory.openSession();

        TypedQuery<Course> query = session.createQuery(hqlQuery, Course.class);
        query.setParameter("id", id);

        try{
            return query.getResultList();
        }catch(Exception e){
            return null;
        }finally {
            session.close();
        }
    }
}
