package edu.carrollcc.cis232.HSQLDBExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExample {

	public static void main(String[] args) throws SQLException {
		final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee";
		
		// Create a connection to the database.
		Connection conn = DriverManager.getConnection(DB_URL);
		
		Statement statement = conn.createStatement();
		ResultSet results = statement.executeQuery("SELECT Description FROM Coffee");
		
		while(results.next()){
			System.out.println(results.getString("Description"));
		}
		
		conn.close();
	}

}
