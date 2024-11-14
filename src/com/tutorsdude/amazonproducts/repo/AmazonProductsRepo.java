package com.tutorsdude.amazonproducts.repo;

import java.util.List;

import com.tutorsdude.amazonproducts.dto.Products;

public interface AmazonProductsRepo {
	
	public boolean save(Products products);
	
	public Products findProductById(int id);
	
	public Products findProductByName(String name);
	
	public boolean updatePriceById(int id,int price);
	
	public boolean delete(String name);
	
	public List<Products> readAll();
	
	
	

}
