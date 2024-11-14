package com.tutorsdude.amazonproducts.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tutorsdude.amazonproducts.dbcredentials.DbCredentials;

public class DbUtils {
	
	public static Connection getConnection() {
		
		try {
			Class.forName(DbCredentials.DRIVER.getValue());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return DriverManager.getConnection(DbCredentials.HOST.getValue(),DbCredentials.USER.getValue(),
					DbCredentials.PASSWORD.getValue());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
