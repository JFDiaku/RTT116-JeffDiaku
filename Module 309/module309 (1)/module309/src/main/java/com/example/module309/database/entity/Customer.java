package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    // To add a one to many relationship steps
    // 1) Goto the example website and create the @OneToMany and @ManyToOne annoations
    // 2) In the entity with the foreign key mark that colum as insertable = false and updateable = false
    // 3) Add the @ToString.Exclude annotation to both sides

//    Sales_rep_employee is a foreign key in customers table
//    many customers can have one sales_rep_employee
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sales_rep_employee_id", nullable = false)
    @ToString.Exclude
    private Employee employee;

    // now that we have the @ManyToOne mapping using the same column name for the @JoinColumn
    // hibernate is confused as the colum sales_rep_employee_id is not ambigous to hibernate
    // to solve this problem, we make this field read only by adding insertable = false and updateable = false
    // TL;DR; - The foreign key must be marked as read only for hibernate
    @Column(name = "sales_rep_employee_id", insertable = false, updatable = false)
    private int sales_rep_employee_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name")
    private String customer_name;

    @Column(name = "contact_lastname")
    private String contact_lastname;

    @Column(name = "contact_firstname")
    private String contact_firstname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address_line1")
    private String address_line1;

    @Column(name = "address_line2")
    private String address_line2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "country")
    private String country;

    @Column(name = "credit_limit", columnDefinition = "DECIMAL")
    private double credit_limit;



}
