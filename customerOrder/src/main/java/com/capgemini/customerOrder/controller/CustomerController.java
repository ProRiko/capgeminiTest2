package com.capgemini.customerOrder.controller;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.customerOrder.Dao.CustomerDAOImpl;
import com.capgemini.customerOrder.entity.Customer;
import com.capgemini.customerOrder.entity.Order;

public class CustomerController {

    public static void main(String[] args) {

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();

        Customer customer = new Customer();
        customer.setCustomerName("Rohit Sharma");
        customer.setEmail("rohit@gmail.com");
        customer.setGender("Male");
        customer.setPhone(9876543210L);
        customer.setRegistrationDate(LocalDate.now());

        Order order = new Order();
        order.setOrderId(101);
        order.setProduct("Laptop");

        order.setPrice(75000);
        order.setOrderDate1(LocalDate.now());

        customer.setOrder(order);
        order.setCustomer(customer);

        System.out.println(customerDAO.saveCustomer(customer));

        Customer c = customerDAO.getCustomerById(1);
        if (c != null) {
            System.out.println("Customer Name: " + c.getCustomerName());
        }

        c.setPhone(9999999999L);
        System.out.println(customerDAO.updateCustomer(c));

        List<Customer> customers = customerDAO.getAllCustomers();
        for (Customer cust : customers) {
            System.out.println(cust.getCustomerName());
        }

        Customer emailCustomer = customerDAO.getCustomerByEmail("rohit@gmail.com");
        if (emailCustomer != null) {
            System.out.println("Found: " + emailCustomer.getCustomerName());
        }


        System.out.println(customerDAO.deleteCustomerById(1));
    }
}
