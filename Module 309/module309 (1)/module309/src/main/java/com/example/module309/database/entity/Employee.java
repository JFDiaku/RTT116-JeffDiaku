package com.example.module309.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="employees")
@Setter
@Getter
public class Employee {

//   Tells hibernate that this is a primary key for this entity
    @Getter
    @Id
//    Tells hibernate to auto increment id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

// one employee can have many customers
//    one to many relationship
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Customer> customers;

    @Column(name = "office_id")
    private int officeId;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "email")
    private String email;

    @Column(name = "reports_to", nullable = true)
    private Integer reportsTo;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "vacation_hours", nullable = true)
    private Integer vacationHours;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    public Employee(){

    }

    public Employee(int id, int officeId, String lastname, String firstname, String email, int reportsTo, String jobTitle, int vacationHours, String profileImageUrl) {
        this.id = id;
        this.officeId = officeId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
        this.vacationHours = vacationHours;
        this.profileImageUrl = profileImageUrl;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", officeId=" + officeId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", reportsTo=" + reportsTo +
                ", jobTitle='" + jobTitle + '\'' +
                ", vacationHours=" + vacationHours +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                '}';
    }
}
