package edu.carrollcc.cis232.HSQLDBExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteCoffee {

	final static String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee;ifexists=true";
	
	public static void main(String[] args) throws Exception {
		System.out.println("Input the product number you would like to delete:");
		deleteByProdNum(new Scanner(System.in).nextLine());
	}

	private static void deleteByProdNum(String prodNum) throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL);
		
		Statement statement = conn.createStatement();
		
		String sql = String.format("DELETE FROM Coffee "
				+ "WHERE ProdNum = '%s';", prodNum);
		
		int count = statement.executeUpdate(sql);
		
		System.out.println(count + " row(s) deleted");
		
		conn.close();
	}
}
