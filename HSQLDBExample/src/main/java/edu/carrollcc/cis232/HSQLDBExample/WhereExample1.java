package edu.carrollcc.cis232.HSQLDBExample;

import java.sql.*;

public class WhereExample1 {

	public static void main(String[] args) throws Exception {
		final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee;ifexists=true";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
		Statement statement = conn.createStatement();
		
		ResultSet results = statement.executeQuery("SELECT * FROM Coffee WHERE Description LIKE '%Dark%';");

		while(results.next()){
			System.out.printf("%s %s %f%n", results.getString(1),
					results.getString(2), results.getBigDecimal(3));
		}
		
		conn.close();
	}

}
