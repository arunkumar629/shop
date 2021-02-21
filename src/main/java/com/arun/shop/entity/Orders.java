package com.arun.shop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orders {
	// This should not be there, or we need to move to a separate table.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long orderId;

	@JsonIgnore
	@ManyToOne
	//@JoinColumn(name = "userId")
	private User user;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "productId")
	private Product product;

	public Orders() {
		super();
	}

	public Orders(long orderId) {
		super();
		this.orderId = orderId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int hashCode() {
		return Long.hashCode(orderId);
	}

}
