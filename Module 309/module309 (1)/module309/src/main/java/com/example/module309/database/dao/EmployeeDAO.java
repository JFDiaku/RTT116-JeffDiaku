package com.example.module309.database.dao;


import com.example.module309.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {
//    @Query("Select c from Customer c where c.contactFirstname = :firstname")
    @Query("SELECT e from Employee e WHERE :name <> '' AND e.lastname LIKE %:name% OR e.firstname LIKE %:name% OR e.email LIKE %:name%")
    List<Employee> findEmployeeByName(String name);

    @Query("SELECT e from Employee e WHERE e.id = :id")
    Employee findEmployeeId(int id);
}
