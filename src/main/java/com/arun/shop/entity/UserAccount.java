package com.arun.shop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long aid;
	
	long accountNumber;
	long balance;
	
	@OneToOne(mappedBy="userAccount",cascade={ CascadeType.PERSIST,
			CascadeType.REFRESH})
private User user;

	public UserAccount() {
		super();
	}

	public UserAccount(long aid, long accountNumber, long balance, User user) {
		super();
		this.aid = aid;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.user = user;
	}

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	


	}
