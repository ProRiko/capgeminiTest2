package com.capgemini.customerOrder.controller;

import com.capgemini.customerOrder.Dao.OrderDAOImpl;
import com.capgemini.customerOrder.entity.Order;

public class OrderController {

    public static void main(String[] args) {

        OrderDAOImpl orderDAO = new OrderDAOImpl();

        Order order = new Order();
        order.setProduct("Laptop");
        order.setPrice(75000);

        System.out.println(orderDAO.saveOrder(order));

        Order fetchedOrder = orderDAO.getOrderById(1);
        if (fetchedOrder != null) {
            System.out.println("Order Details: " + fetchedOrder);
        }

        fetchedOrder.setPrice(70000);
        System.out.println(orderDAO.updateOrder(fetchedOrder));

        Order updatedOrder = orderDAO.getOrderById(1);
        System.out.println("Updated Order: " + updatedOrder);

        System.out.println(orderDAO.deleteOrderById(1));
    }
}