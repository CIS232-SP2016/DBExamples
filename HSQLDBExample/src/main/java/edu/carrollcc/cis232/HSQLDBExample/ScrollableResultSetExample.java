package edu.carrollcc.cis232.HSQLDBExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ScrollableResultSetExample {

	public static void main(String[] args) {
		// Create a named constant for the URL.
	      // NOTE: This value is specific for Java DB.
	      final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee;ifexists=true";
	      
	      try
	      {
	         // Create a connection to the database.
	         Connection conn = DriverManager.getConnection(DB_URL);
	         
	         // Create a Statement object.
	         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	        		 ResultSet.CONCUR_UPDATABLE);
	         
	         // Create a string with a SELECT statement.
	         String sqlStatement = "SELECT Description, Price FROM Coffee";
	         
	         // Send the statement to the DBMS.
	         ResultSet result = stmt.executeQuery(sqlStatement);
	         
	         // Display a header for the listing.
	         System.out.println("Coffees Found in the Database");
	         System.out.println("-----------------------------");
	         
	         //Using fancy scrollable resultsets to muck with data
	         result.last();
	         result.updateDouble("Price", 1.00);
	         result.updateRow();
	         result.beforeFirst();
	         
	         // get number of rows
	         result.last();
	         int count = result.getRow();
	         result.beforeFirst();
	         System.out.printf("There are %,d rows%n", count);
	         
	         ResultSetMetaData meta = result.getMetaData();
	         System.out.printf("There are %,d columns%n", meta.getColumnCount());
	         System.out.printf("The first column is named %s%n", meta.getColumnName(1));
	         System.out.printf("The first column type is %s%n", meta.getColumnTypeName(1));
	         System.out.printf("The column has a display size of %d%n", meta.getColumnDisplaySize(1));
	         System.out.printf("The first column comes from table %s%n", meta.getTableName(1));
	         
	         // Display the contents of the result set.
	         // The result set will have three columns.
	         while (result.next())
	         {
	            System.out.printf("%s $%.2f%n", result.getString("Description"), result.getDouble("Price"));
	         }
	         
	         // Close the connection.
	         conn.close();
	         
	      }
	      catch(Exception ex)
	      {
	         System.out.println("ERROR: " + ex.getMessage());
	      }
	   }

}
