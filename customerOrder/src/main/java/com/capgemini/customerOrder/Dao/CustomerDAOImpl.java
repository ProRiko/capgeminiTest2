package com.capgemini.customerOrder.Dao;

import java.util.List;

import javax.persistence.*;

import com.capgemini.customerOrder.entity.Customer;

public class CustomerDAOImpl {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU01");

    public String saveCustomer(Customer customer) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();

        em.close();

        return "Customer Saved Successfully";
    }

    public String updateCustomer(Customer customer) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();

        em.close();

        return "Customer Updated Successfully";
    }

    public String deleteCustomerById(int id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Customer customer = em.find(Customer.class, id);

        if (customer != null) {
            em.remove(customer);
        }

        em.getTransaction().commit();
        em.close();

        return "Customer Deleted Successfully";
    }

    public Customer getCustomerById(int id) {

        EntityManager em = emf.createEntityManager();

        Customer customer = em.find(Customer.class, id);

        em.close();

        return customer;
    }

    public List<Customer> getAllCustomers() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Customer> query =
                em.createQuery("SELECT c FROM Customer c", Customer.class);

        List<Customer> customers = query.getResultList();

        em.close();

        return customers;
    }

    public Customer getCustomerByEmail(String email) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Customer> query = em.createQuery(
                "SELECT c FROM Customer c WHERE c.email = :email",
                Customer.class);

        query.setParameter("email", email);

        Customer customer = query.getSingleResult();

        em.close();

        return customer;
    }
}