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

public class StudentService implements  StudentI{
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @Override
    public List<Student> getAllStudents(){
        Session session = factory.openSession();
        String hqlQuery = "SELECT s FROM Student s ";

        TypedQuery<Student> query = session.createQuery(hqlQuery, Student.class);

        try{
            return query.getResultList();
        }catch(Exception e){
            return null;
        }finally{
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
        Session session = factory.openSession();
        String hqlQuery = "SELECT s FROM Student s WHERE s.email = :email";

        TypedQuery<Student> query = session.createQuery(hqlQuery, Student.class);
        query.setParameter("email", email);

        try{
            return query.getSingleResult();
        }catch(Exception e){
            return null;
        }finally{
            session.close();
        }
    }

    @Override
    public boolean validateStudent(String email, String password){
        boolean found = false;
        Session session = factory.openSession();
        String hqlQuery = "SELECT s FROM Student s WHERE s.email = :email AND s.password = :password";

        TypedQuery<Student> query = session.createQuery(hqlQuery, Student.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        try{
            if(query.getSingleResult() != null){
                found = true;
            };
            return found;
        }catch(Exception e){
            session.getTransaction().rollback();
            return found;
        }finally{
            session.close();
        }
    }

    @Override
    public void registerStudentToCourse(String email, int courseId){
        Session session = factory.openSession();

        try {
            session.getTransaction().begin();

            // Retrieve the Student and Course entities
            Student student = session.get(Student.class, email);
            Course course = session.get(Course.class, courseId);

            // Check if both exist
            if (student == null) {
                throw new IllegalArgumentException("Student not found with email: " + email);
            }
            if (course == null) {
                throw new IllegalArgumentException("Course not found with ID: " + courseId);
            }

            // Check if the association already exists (to prevent duplicates)
            boolean alreadyRegistered = student.getStudentCourses().stream()
                    .anyMatch(sc -> sc.getCourse().getId() == courseId);

            if (alreadyRegistered) {
                System.out.println("Student is already registered for this course.");
            } else {
                // Create a new StudentCourse object
                StudentCourse studentCourse = new StudentCourse(student, course);

                // Add the association to the Student and Course
                student.getStudentCourses().add(studentCourse);
                course.getStudentCourses().add(studentCourse);

                // Persist the association
                session.persist(studentCourse);

                System.out.println("Successfully registered student for the course.");
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }

    @Override
    public List<Course> getStudentCourses(String email){
        Session session = factory.openSession();
        String hqlQuery = "SELECT sc.course FROM StudentCourse sc WHERE sc.student.email = :email";
        TypedQuery<Course> query = session.createQuery(hqlQuery, Course.class);
        query.setParameter("email", email);

        try{
            return query.getResultList();
        }catch(Exception e){
            return null;
        }finally{
            session.close();
        }
    }
}
