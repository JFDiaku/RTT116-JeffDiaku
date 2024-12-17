package com.example.module309.database.dao;

import com.example.module309.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, Long> {

    @Query("Select c from Customer c where :name <> '' AND c.contactFirstname LIKE %:name% or c.contactLastname LIKE %:name% or c.customerName LIKE %:name% ")
    List<Customer> findCustomerByName(String name);
}
