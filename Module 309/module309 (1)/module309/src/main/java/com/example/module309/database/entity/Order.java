package com.example.module309.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @ToString.Exclude
    private Customer customer;


    @Column(name = "customer_id",insertable = false, updatable = false)
    private int customerId;

    @Column(name = "order_date", columnDefinition = "DATE")
    private Date orderDate;

    @Column(name = "required_date", columnDefinition = "DATE")
    private Date requiredDate;

    @Column(name = "shipped_date", columnDefinition = "DATE")
    // this temorpal type has to match the database type .. in the case of shipped date the database
    // does not contain the timeinformation
    @Temporal(TemporalType.DATE)
    private Date shippedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

}
