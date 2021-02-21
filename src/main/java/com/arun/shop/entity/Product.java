package com.arun.shop.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.util.StreamUtils;

//import com.sun.tools.javac.util.List;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long pid;

	String productName;
	String productDesc;
	String image;

	@OneToMany(mappedBy = "product")
	private List<Orders> orders;

	public Product() {
		super();
	}

	public Product(long pid, String productName, String productDesc, String image, List<Orders> orders) {
		super();
		this.pid = pid;
		this.productName = productName;
		this.productDesc = productDesc;
		this.image = image;
		this.orders = orders;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	@Transient
	public String getImage() throws IOException {
		//Updated method for approach 1. This will convert the image to Base64 in the get method.
		InputStream in = getClass().getResourceAsStream("/user-photos/2/laptop.jpg");
		System.out.println("Product Entity Geting the image for " + (null == in ? "is null" : "is not nulll"));
		byte[] encodedByteArray = StreamUtils.copyToByteArray(in);
		return new String(Base64.getEncoder().encodeToString(encodedByteArray));
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

}
