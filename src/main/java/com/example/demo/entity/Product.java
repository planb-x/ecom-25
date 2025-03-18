package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long productId;
	Long userId;
	String productName;
	int price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long productId, Long userId, String productName, int price) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.productName = productName;
		this.price = price;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", userId=" + userId + ", productName=" + productName + ", price="
				+ price + "]";
	}
	
	
}
