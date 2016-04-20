package edu.carrollcc.cis232.HSQLDBExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class UserUpdatePriceOfBolivian {

	public static void main(String[] args) throws Exception {
		final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee;ifexists=true";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
		Statement statement = conn.createStatement();
		
		String price = JOptionPane.showInputDialog("New price of Bolivian coffee?");
		
		String sql = String.format("update Coffee set Price = %s "
				+ "where Description LIKE 'Bolivian%%'", price);
		
		int count = statement.executeUpdate(sql);
		
		System.out.println(count + " row(s) updated");
		
		conn.close();
	}

}
