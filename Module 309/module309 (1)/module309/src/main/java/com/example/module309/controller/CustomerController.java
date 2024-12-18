package com.example.module309.controller;

import com.example.module309.database.dao.CustomerDAO;
import com.example.module309.database.dao.EmployeeDAO;
import com.example.module309.database.entity.Customer;
import com.example.module309.database.entity.Employee;
import com.example.module309.form.CreateCustomerFormBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CustomerController {
    // serverity of the error message increases going down
// as developers 90% of the time we are going to use DEBUG
// TRACE   -- this is very low level and not often used by us .. more for creators of libraries
// DEBUG   -- this is what we use most of the time when we wnat to print out stuff that helps us build
// INFO    -- this is for information that is important like the messages that spring prints when it starts up
// WARN    -- this is a potential problem or something of note but it is not an error
// ERROR   -- this is for errors like making an api call that failed OR if an exception is thrown


    // slf4j is not an implementation of logging it is a specification
// most if not all other logging libraries have come to use this specification for their implementation
// log4j was the most commonly used logging library for a long time and you will probably encounter it
//@Slf4j  <-  this is from lombok and all it does is line 40
    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/customer/create")
    public ModelAndView createCustomer(){
        LOG.debug("DEBUG LEVEL");
        LOG.info("INFO LEVEL");
        LOG.warn("WARNING LEVEL");
        LOG.error("ERROR LEVEL");

        return new ModelAndView("customer/createCustomer");
    }

    @GetMapping("/customer/createCustomer")
    public ModelAndView createCustomerSubmit(CreateCustomerFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();

        response.setViewName("customer/createCustomer");

        LOG.debug(form.toString());

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                LOG.debug(error.toString());
            }
        }

        Customer customer = new Customer();
        customer.setCustomerName(form.getCustomerName());
        customer.setContactFirstname(form.getFirstName());
        customer.setContactLastname(form.getLastName());
        customer.setPhone(form.getPhone());
        customer.setAddressLine1(form.getAddressLine1());
        customer.setCity(form.getCity());
        customer.setCountry(form.getCountry());

        Employee employee = employeeDAO.findEmployeeId(1056);

        customer.setEmployee(employee);

        customerDAO.save(customer);

        return response;
    }
}
