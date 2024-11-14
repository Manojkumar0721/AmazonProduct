package com.tutorsdude.amazonproducts.service;

import java.util.List;

import com.tutorsdude.amazonproducts.dto.Products;

public interface AmazonProductsService {
	
	public boolean save(Products products);
	
	public boolean validateProducts(Products products);
	
	public Products findProductsById(int id);
	
	public Products findProductsByName(String name);
	
	public boolean updatePriceById(int id,int price);
	
	public boolean deleteByName(String name);
	
	public List<Products> readAll();
	
	
	
	

}
