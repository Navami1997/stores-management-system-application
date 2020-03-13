package com.capgemini.storesmanagementsystem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.ToString.Exclude;

public class ProductInfoBean {
	
	
	private int productId;
	private String productName;
	private double costPrice;
	private int quantity;
	private double sellingPrice;
	private String description;
	private double productCost;
	private int minimumQuantity;
	public int getMinimumQuantity() {
		return minimumQuantity;
	}

	public void setMinimumQuantity(int minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductInfoBean() {
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
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
		ProductInfoBean other = (ProductInfoBean) obj;
		if (productId != other.productId)
			return false;
		return true;
	}
	
}
