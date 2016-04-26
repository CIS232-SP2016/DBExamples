package edu.carrollcc.cis232.HSQLDBExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.carrollcc.cis232.HSQLDBExample.model.Coffee;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CoffeeTableViewApplication extends Application {

	private TableView<Coffee> table = new TableView<Coffee>();
	private final ObservableList<Coffee> data = FXCollections.observableArrayList();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		Scene scene = new Scene(new Group());
		stage.setTitle("Coffee DB");
		stage.setWidth(450);
		stage.setHeight(500);

		final Label label = new Label("Coffees");
		label.setFont(new Font("Arial", 20));

		loadData();
		setupTableLayout();

		table.setItems(data);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);
		stage.show();
	}

	private void setupTableLayout() {
		TableColumn prodNumCol = new TableColumn("Product Number");
		prodNumCol.setCellValueFactory(new PropertyValueFactory<Coffee, String>("prodNum"));

		TableColumn descriptionCol = new TableColumn("Description");
		descriptionCol.setCellValueFactory(new PropertyValueFactory<Coffee, String>("description"));

		TableColumn priceCol = new TableColumn("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<Coffee, Double>("price"));

		table.getColumns().addAll(prodNumCol, descriptionCol, priceCol);
		table.setPrefWidth(410);
		table.autosize();
	}

	protected void loadData() {
		// Create a named constant for the URL.
		// NOTE: This value is specific for Java DB.
		final String DB_URL = "jdbc:hsqldb:file:CoffeeDB/coffee;ifexists=true";

		try {
			// Create a connection to the database.
			Connection conn = DriverManager.getConnection(DB_URL);

			// Create a Statement object.
			Statement stmt = conn.createStatement();

			// Create a string with a SELECT statement.
			String sqlStatement = "SELECT ProdNum, Description, Price FROM Coffee";

			// Send the statement to the DBMS.
			ResultSet result = stmt.executeQuery(sqlStatement);

			// Display the contents of the result set.
			// The result set will have three columns.
			while (result.next()) {
				data.add(new Coffee(result.getString("ProdNum"), result.getString("Description"),
						result.getDouble("Price")));
			}

			// Close the connection.
			conn.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

}
