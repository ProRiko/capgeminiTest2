package com.capgemini.customerOrder.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "customername")
	private String customerName;

	@Column(name = "email")
	private String email;

	@Column(name = "gender")
	private String gender;

	@Column(name = "phone")
	private long phone;

	@Column(name = "registrationdate")
	private LocalDate registrationDate;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Order order;

	public Customer() {
	}

	public Customer(int id, String customerName, String email, String gender, long phone,
			LocalDate registrationDate, Order order) {
		this.id = id;
		this.customerName = customerName;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
		this.registrationDate = registrationDate;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerName, email, gender, id, phone, registrationDate);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		Customer other = (Customer) obj;

		return id == other.id &&
			   phone == other.phone &&
			   Objects.equals(customerName, other.customerName) &&
			   Objects.equals(email, other.email) &&
			   Objects.equals(gender, other.gender) &&
			   Objects.equals(registrationDate, other.registrationDate);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", email=" + email +
				", gender=" + gender + ", phone=" + phone +
				", registrationDate=" + registrationDate + "]";
	}
}