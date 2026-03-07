package com.capgemini.customerOrder.Dao;

import javax.persistence.*;

import com.capgemini.customerOrder.entity.Order;

public class OrderDAOImpl {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU01");

    public String saveOrder(Order order) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();

        em.close();

        return "Order Saved Successfully";
    }

    public String updateOrder(Order order) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();

        em.close();

        return "Order Updated Successfully";
    }

    public String deleteOrderById(int id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Order order = em.find(Order.class, id);

        if (order != null) {
            em.remove(order);
        }

        em.getTransaction().commit();

        em.close();

        return "Order Deleted Successfully";
    }

    public Order getOrderById(int id) {

        EntityManager em = emf.createEntityManager();

        Order order = em.find(Order.class, id);

        em.close();

        return order;
    }
}