package com.tutorsdude.amazonproducts.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {

	private int id;
	private String name;
	private int price;
	private String description;
	private String catagory;
	private float rating;

	public Products(int id, int price) {
		this.id = id;
		this.price = price;
	}

	public Products(String name) {
		this.name = name;
	}
	
	public Products(int id) {
		this.id = id;
	}

	

}
