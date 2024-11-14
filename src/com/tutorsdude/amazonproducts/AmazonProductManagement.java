package com.tutorsdude.amazonproducts;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import com.tutorsdude.amazonproducts.dto.Products;
import com.tutorsdude.amazonproducts.service.AmazonProductServiceImpl;
import com.tutorsdude.amazonproducts.service.AmazonProductsService;

public class AmazonProductManagement {

	AmazonProductsService service = new AmazonProductServiceImpl();
	Products products = new Products();
	

	public static void main(String[] args) {

		AmazonProductManagement amazonProductManagement = new AmazonProductManagement();

		amazonProductManagement.products();
	

	}

	public void products() {
		Scanner sc = new Scanner(System.in);
		System.out.println("A. Add products.");
		System.out.println("B. Update product.");
		System.out.println("C. Delete products.");
		System.out.println("D. Find products.");
		System.out.println("E. View products.");
	
		String character = sc.nextLine();

		System.out.println("\n");

		switch (character.toUpperCase()) {
		case "A":
			addProduct();
			break;
		case "B":
			updatePrice();
			break;
		case "C":
			deleteProduct();
			break;
		case "D":
			searchProduct();
			break;
		case "E":
			viewProduct();
			break;
		default:
			System.out.println("Invalid option! please enter again");
			break;
		}

	}

	public void addProduct() {
		Scanner scanner = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("Add product:");
		System.out.println("Enter Id:");
		int id = scanner.nextInt();
		System.out.println("Enter Name of the product:");
		String name = sc.nextLine();
		System.out.println("Enter Price of the product:");
		int price = scanner.nextInt();
		System.out.println("Enter product description:");
		String description = sc.nextLine();
		System.out.println("Enter catagory:");
		String catagory = sc.nextLine();
		System.out.println("Enter Ratings:");
		float rating = scanner.nextFloat();
		Products products = new Products(id, name, price, description, catagory, rating);
		boolean status = service.save(products);
		if (status == true) {
			System.out.println("Product added successfully");
		} else {
			System.out.println("ERROR while adding product");
		}

	}

	public void updatePrice() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product ID:");
		int id = scanner.nextInt();
		System.out.println("Enter Updating price:");
		int price = scanner.nextInt();
		Products products = new Products(id, price);
		boolean status = service.updatePriceById(id, price);
		if (status == true) {
			System.out.println("Product updated successfully");
		} else {
			System.out.println("ERROR while updating product");
		}

	}

	public void deleteProduct() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter product name:");
		String name = scanner.nextLine();
		Products products = new Products(name);
		boolean status = service.deleteByName(name);
		if (status == true) {
			System.out.println("Product deleted successfully");
		} else {
			System.out.println("ERROR while deleting product");
		}
	}

	public void searchProduct() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product ID:");
		int id = scanner.nextInt();
		Products products = new Products(id);
		Products status = service.findProductsById(id);
		System.out.println(status);
	}

	public void viewProduct() {
		
		Scanner scanner = new Scanner(System.in);
	    
		System.out.println("A.Price low to high");
		System.out.println("B.Price high to low");
		System.out.println("C.Rating low to High");
		System.out.println("D.Rating high To low");
		String value = scanner.nextLine();
		
		switch (value.toUpperCase()) {
		case "A" :
			priceLowToHigh();
			break;
		case "B" :
			priceHighToLow();
			break;
		case "C":
			ratingLowToHigh();
			break;
		case "D":
			ratingHighToLow();
		    break;
		default:
			System.out.println("Invalid option!");
			break;
			
		}
		
		
	}
	
	
	public void priceLowToHigh() {
		
		
		Comparator<Products> priceLowToHighComparator = new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return Integer.compare(o1.getPrice(), o2.getPrice());
			}
			
		};
		List<Products> result = service.readAll();
		
		result.sort(priceLowToHighComparator);
		
		for(Products product :result) {
			System.out.println(product);
		}
		
		
	    
		
	}
	
	public void priceHighToLow() {
		
	
		Comparator<Products> priceHighToLow = new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return Integer.compare(o2.getPrice(), o1.getPrice());
			}
			
		};
		List<Products> result = service.readAll();
		
		result.sort(priceHighToLow);

		for (Products product : result) {
			System.out.println(product);
		}
		
	}
	
	public void ratingLowToHigh() {
		
		Comparator<Products> ratingLowToHigh = new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return Float.compare(o1.getRating(), o2.getRating());
			}
			
		};
		
		List<Products> result = service.readAll();
        result.sort(ratingLowToHigh);
		for (Products product : result) {
			System.out.println(product);
		}
	}
	
	public void ratingHighToLow() {
		
		Comparator<Products> ratingHighToLow = new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				return Float.compare(o2.getRating(), o1.getRating());
			}
			
		};
		List<Products> result = service.readAll();
        result.sort(ratingHighToLow);
		for (Products product : result) {
			System.out.println(product);
		}
	}
	
	

}
