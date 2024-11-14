package com.tutorsdude.amazonproducts.dbcredentials;

public enum DbCredentials {
	
	HOST("jdbc:mysql://localhost:3306/amazon"),USER("root"),PASSWORD("Manojkumary@07"),
	DRIVER("com.mysql.cj.jdbc.Driver");

	String value;
	
	private DbCredentials(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
