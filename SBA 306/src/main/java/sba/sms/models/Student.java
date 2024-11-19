package sba.sms.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.*;


/**
 * Student is a POJO, configured as a persistent class that represents (or maps to) a table
 * name 'student' in the database. A Student object contains fields that represent student
 * login credentials and a join table containing a registered student's email and course(s)
 * data. The Student class can be viewed as the owner of the bi-directional relationship.
 * Implement Lombok annotations to eliminate boilerplate code.
 */
@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "studentCourses")
public class Student {
    @Id
    @Column(name = "email", length = 50, nullable = false, unique = true)
    @NonNull
    private String email;

    @Column(name = "name", length = 50, nullable = false)
    @NonNull
    private String name;

    @Column(name = "password", length = 50, nullable = false)
    @NonNull
    private String password;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StudentCourse> studentCourses = new ArrayList<>();
}



