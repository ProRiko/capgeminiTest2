package com.capgemini.customerOrder.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;

	@Column(name = "product")
	private String product;

	@Column(name = "price")
	private double price;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Order() {
	}

	public Order(int orderId, String product, double price, Customer customer) {
		this.orderId = orderId;
		this.product = product;
		this.price = price;
		this.customer = customer;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", product=" + product + ", price=" + price + "]";
	}

}