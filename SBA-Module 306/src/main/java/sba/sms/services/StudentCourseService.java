package sba.sms.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sba.sms.models.Course;
import sba.sms.models.Student;
import sba.sms.models.StudentCourse;

public class StudentCourseService {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public void createStudentCourse(StudentCourse studentCourse) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(studentCourse);
        session.getTransaction().commit();
    }
}
