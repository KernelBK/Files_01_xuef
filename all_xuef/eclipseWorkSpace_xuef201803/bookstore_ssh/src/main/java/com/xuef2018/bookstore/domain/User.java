package com.xuef2018.bookstore.domain;

public class User {
	private int id;
	private String name;
	private int accountid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", accountid=" + accountid
				+ "]";
	}
	
}
