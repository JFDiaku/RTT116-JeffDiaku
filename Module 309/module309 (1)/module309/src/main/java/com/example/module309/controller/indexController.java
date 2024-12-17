package com.example.module309.controller;

import com.example.module309.database.dao.CustomerDAO;
import com.example.module309.database.dao.EmployeeDAO;
import com.example.module309.database.entity.Customer;
import com.example.module309.database.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    private CustomerDAO customerdao;

    @Autowired
    private EmployeeDAO employeedao;

    @GetMapping("/index")
    public ModelAndView index(@RequestParam (required = false) String Search) {
        ModelAndView response = new ModelAndView();

        // this is our index.jsp
        response.setViewName("index");

        List<Customer> firstNames = customerdao.findCustomerByName(Search);
        for(Customer c: firstNames){
            System.out.println(c.toString());
        }
        response.addObject("names", firstNames);

        return response;
    }

    @GetMapping("/customers")
    public ModelAndView search(@RequestParam (required = false) String customerName) {
        ModelAndView response = new ModelAndView();

        // this is our index.jsp
        response.setViewName("search");


        List<Customer> Customers;
        if(customerName == null || customerName.isEmpty()){
            Customers = Collections.emptyList();
        }else{
            Customers = customerdao.findCustomerByName(customerName);
            for(Customer c: Customers) {
                System.out.println(c.toString());
            }
        }

        response.addObject("Customers", Customers);


        return response;
    }

    @GetMapping("/employees")
    public ModelAndView employees(@RequestParam (required = false) String employee) {
        ModelAndView response = new ModelAndView();

        response.setViewName("employees");

        List<Employee> employees;
        if(employee == null || employee.isEmpty()){
            employees = Collections.emptyList();
        }else{
            employees = employeedao.findEmployeeByName(employee);
            for(Employee e: employees) {
                System.out.println(e.toString());
            }
        }
        response.addObject("employees", employees);

        return response;
    }

    @GetMapping("/customer/create")
    public ModelAndView createCustomer() {
        ModelAndView response = new ModelAndView();

        response.setViewName("customer/createCustomer");

        return response;
    }

}
