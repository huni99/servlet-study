package com.gn.dto;

import lombok.Data;

@Data
public class Product {
	private int code;
	private String name;
	private int price;
	public Product(int code, String name, int price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	
}
