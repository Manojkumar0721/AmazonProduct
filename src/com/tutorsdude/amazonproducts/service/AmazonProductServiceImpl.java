package com.tutorsdude.amazonproducts.service;

import java.util.List;

import com.tutorsdude.amazonproducts.dto.Products;
import com.tutorsdude.amazonproducts.repo.AmazonProductsRepoImpl;

public class AmazonProductServiceImpl implements AmazonProductsService{
	
	AmazonProductsRepoImpl repo = new AmazonProductsRepoImpl();
	
	
	@Override
	public boolean validateProducts(Products products) {
		if(products!=null) {
			if(products.getPrice()>100) {
				System.out.println("Product is valid");
				return true;
			}
			System.out.println("Product invalid");
			return false;
		}
		System.out.println("product cannot be taken plz inset only valid products");
		return false;
	}

	@Override
	public boolean save(Products products) {
		if(validateProducts(products)) {
			repo.save(products);
			System.out.println("Product Saved");
			return true;
		}
		System.out.println("Product not Saved");
		return false;
	}

	@Override
	public Products findProductsById(int id) {
        if(id>0) {
        	return repo.findProductById(id);
        }
        System.out.println("product is not avilable at this time");
		return null;
	}
	
	@Override
	public Products findProductsByName(String name) {
		if(name!=null) {
			return repo.findProductByName(name);
		}
		System.out.println("Name is invalid");
		return null;
	}

	@Override
	public boolean updatePriceById(int id, int price) {
		if(price>100) {
			if(id>0) {
				return repo.updatePriceById(id, price);
			}
		}
		System.out.println("Price not updated");
		return false;
	}

	@Override
	public boolean deleteByName(String name) {
		if(name!=null) {
			return repo.delete(name);
		}
		System.out.println("product is not able to delete try agin");
		return false;
	}

	@Override
	public List<Products> readAll() {
		return repo.readAll();
	}

	



}
