package com.tutorsdude.amazonproducts.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tutorsdude.amazonproducts.dbutils.DbUtils;
import com.tutorsdude.amazonproducts.dto.Products;

public class AmazonProductsRepoImpl implements AmazonProductsRepo {

	Products products = new Products();

	@Override
	public boolean save(Products products) {

		Connection connection = DbUtils.getConnection();

		String insertQuery = "insert into products(id,name,price,description,catagory,rating) values(?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setInt(1, products.getId());
			preparedStatement.setString(2, products.getName());
			preparedStatement.setInt(3, products.getPrice());
			preparedStatement.setString(4, products.getDescription());
			preparedStatement.setString(5, products.getCatagory());
			preparedStatement.setFloat(6, products.getRating());

			int rowsAffected = preparedStatement.executeUpdate();

			System.out.println(rowsAffected);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}



	@Override
	public boolean updatePriceById(int id, int price) {

		Connection connection = DbUtils.getConnection();

		String updateQuery = "update products set price = ? where id = ?;";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

			preparedStatement.setInt(1, price);
			preparedStatement.setInt(2, id);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println(rowsAffected);
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(String name) {

		Connection connection = DbUtils.getConnection();

		String deleteQuery = "delete from products where name = ?;";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);

			preparedStatement.setString(1, name);

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println(rowsAffected);
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Products findProductByName(String name) {
		Connection connection = DbUtils.getConnection();

		String findQuery = "select * from products where name = ?;";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(findQuery);

			preparedStatement.setString(1, name);

			ResultSet rset = preparedStatement.executeQuery();

			if (rset.next()) {
				products.setId(rset.getInt("Id"));
				products.setName(rset.getString("Name"));
				products.setPrice(rset.getInt("Price"));
				products.setDescription(rset.getString("Description"));
				products.setCatagory(rset.getString("Catagory"));
				products.setRating(rset.getFloat("Rating"));
			}
			return products;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public Products findProductById(int id) {
		Connection connection = DbUtils.getConnection();

		String findQuery = "select * from products where id = ?;";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(findQuery);

			preparedStatement.setInt(1, id);

			ResultSet rset = preparedStatement.executeQuery();

			if (rset.next()) {
				products.setId(rset.getInt("Id"));
				products.setName(rset.getString("Name"));
				products.setPrice(rset.getInt("Price"));
				products.setDescription(rset.getString("Description"));
				products.setCatagory(rset.getString("Catagory"));
				products.setRating(rset.getFloat("Rating"));
			}
			return products;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Products> readAll() {
		Connection connection = DbUtils.getConnection();

		String readQuery = "select * from products;";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(readQuery);

			ResultSet resultSet = preparedStatement.executeQuery();
    
			List<Products> list = new ArrayList<Products>();

			while (resultSet.next()) {
				Products products = new Products();
				products.setId(resultSet.getInt("Id"));
				products.setName(resultSet.getString("Name"));
				products.setPrice(resultSet.getInt("Price"));
				products.setDescription(resultSet.getString("Description"));
				products.setCatagory(resultSet.getString("Catagory"));
				products.setRating(resultSet.getFloat("Rating"));
                
				list.add(products);

			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
