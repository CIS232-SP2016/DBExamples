package edu.carrollcc.cis232.HSQLDBExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateCoffee {

	public static void main(String[] args) throws Exception {
		final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee;ifexists=true";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
		Statement statement = conn.createStatement();
		
		String sql = "update Coffee set Price = 5.00 "
				+ "where Description LIKE 'Bolivian%'";
		
		int count = statement.executeUpdate(sql);
		
		System.out.println(count + " row(s) updated");
		
		conn.close();
	}
}
