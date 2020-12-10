package com.arun.shop.entity;

import javax.persistence.CascadeType;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.arun.shop.entity.*;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String userName;
	private String password;
	private int age;
	
	@OneToOne(cascade=CascadeType.ALL)
	private UserAccount userAccount;

	public User() {
		super();
	}

	public User(long id, String userName, String password, int age, UserAccount userAccount) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.userAccount = userAccount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	
	
	
}
