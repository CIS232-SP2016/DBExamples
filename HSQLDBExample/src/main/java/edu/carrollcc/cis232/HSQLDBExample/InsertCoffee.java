package edu.carrollcc.cis232.HSQLDBExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertCoffee {

	public static void main(String[] args) throws Exception {
		final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee;ifexists=true";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
		Statement statement = conn.createStatement();
		
		int count = statement.executeUpdate("insert into Coffee values ('Coffee #3', '23-001', 3.00)");
		
		System.out.println(count + " row(s) inserted");
		
		conn.close();
	}
}
