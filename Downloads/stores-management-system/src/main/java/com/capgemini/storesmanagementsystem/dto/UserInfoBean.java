package com.capgemini.storesmanagementsystem.dto;

import java.util.LinkedHashSet;
import java.util.Set;


public class UserInfoBean {
	
	
	private String userName;
	private int id;
	private String password;
	private String email;
	private String role;
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private Set<OrderDetails> orders = new LinkedHashSet<OrderDetails>();
	
	public Set<OrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderDetails> orders) {
		this.orders = orders;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<ProductInfoBean> getProduct() {
		return product;
	}

	public void setProduct(Set<ProductInfoBean> product) {
		this.product = product;
	}

	private Set<ProductInfoBean> product = new LinkedHashSet<ProductInfoBean>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfoBean other = (UserInfoBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
}
