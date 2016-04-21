package edu.carrollcc.cis232.HSQLDBExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowCustomers {

	public static void main(String[] args) {
		// Create a named constant for the URL.
		// NOTE: This value is specific for Java DB.
		final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee;ifexists=true";

		try {
			// Create a connection to the database.
			Connection conn = DriverManager.getConnection(DB_URL);

			// Create a Statement object.
			Statement stmt = conn.createStatement();

			// Create a string with a SELECT statement.
			String sqlStatement = "SELECT * FROM Customer";

			// Send the statement to the DBMS.
			ResultSet result = stmt.executeQuery(sqlStatement);

			// Display a header for the listing.
			System.out.println("Customers Found in the Database");
			System.out.println("-----------------------------");

			// Display the contents of the result set.
			// The result set will have three columns.
			while (result.next()) {
				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
					System.out.print(result.getString(i) + " ");
				}
				System.out.println();
			}

			// Close the connection.
			conn.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

}
