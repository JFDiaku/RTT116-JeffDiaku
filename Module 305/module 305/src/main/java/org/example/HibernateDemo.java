package org.example;

import org.example.database.dao.*;
import org.example.database.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateDemo {
    public static void main(String[] args) {
        // business logic
//        ProductLineDAO productLineDAO = new ProductLineDAO();
//        ProductLine pl = productLineDAO.findById(1);
//
        ProductDAO  productDao = new ProductDAO();
//        Product p = new Product();
//
//
//        p.setBuyPrice(5.99);
//        p.setMsrp(1.99);
//        p.setProductName("New Product");
//        p.setProductCode("NPC");
//        p.setProductDescription("product Decsription");
//        p.setQuantityInStock(50);
//        p.setProductScale("scale");
//        p.setProductVendor("Vendor");
//        p.setProductLine(pl);
//
//
//        //before creating product in DAO id will be null
//        productDao.createProduct(p);
//

//        EmployeeDAO employeeDAO = new EmployeeDAO();
//
//        Employee e  = employeeDAO.findById(1501);
//
//        System.out.println(e);
//
//        for(Customer customers: e.getCustomers() ){
//            System.out.println(customers);
//        }

        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

        OrderDAO orderDAO = new OrderDAO();
        Order o = orderDAO.findOrderById(10101);

        OrderDetail od = new OrderDetail();

        od.setOrder(o);
        od.setProduct(productDao.findById(20));
        od.setQuantity_ordered(100);
        od.setPrice_each(6.00);
        od.setOrder_line_number(10);

        orderDetailDAO.createOrder(od);






    }

}
