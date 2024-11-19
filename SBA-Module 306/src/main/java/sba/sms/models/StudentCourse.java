package sba.sms.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="student_course")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    @ToString.Exclude
    private Course course;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    @ToString.Exclude
    private Student student;

}
