package edu.carrollcc.cis232.HSQLDBExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class PreparedStatementExample {

	public static void main(String[] args) throws Exception {
		final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee;ifexists=true";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
		String sql = "update Coffee set Description = ? where Description LIKE 'Bolivian%'";
		
		PreparedStatement updateBolivian = conn.prepareStatement(sql);
		
		String name = JOptionPane.showInputDialog("New name ending of Bolivian coffees?");
		updateBolivian.setString(1, "Bolivian " + name);
		
		int count = updateBolivian.executeUpdate();
		
		System.out.println(count + " row(s) updated");
		
		conn.close();
	}

}
