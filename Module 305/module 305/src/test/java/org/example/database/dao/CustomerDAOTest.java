package org.example.database.dao;

import org.example.database.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerDAOTest {

    private CustomerDAO customerDAO = new CustomerDAO();

    @Test
    public void findByCustomerIdText(){
        //given
        int givenCustomerId = 123;

        //when
        Customer actual = customerDAO.findCustomerById(givenCustomerId);

        //then
        Assertion.assertEquals('Maven & Zbyszek Co', actual.getContact_firstname());
    }

    @Test
    public void createCustomerTest(){
        //given
        Customer given = new Customer();

        given.setCustomer_name("New Customer");
        given.setContact_firstname("Eric");
        given.setContact_lastname("Eric");
        given.setPhone("5555551212");
        given.setAddress_line1("5555551212");
        given.setAddress_line2("222222");
        given.setCity("city");
        given.setState("asdfasdf");
        given.setPostal_code("023432");
        given.setCountry("USA");
        given.setCredit_limit(234.33);


        //when
        // we want to make sure that the given. getId is null before we insert to the database
        Assertions.assertNull(given.getId());
        Customer.actual = customerDAO.createCustomer(given);

        //then
        Assertions.asserNotNull
    }
}
