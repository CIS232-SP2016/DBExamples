package edu.carrollcc.cis232.HSQLDBExample.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Coffee {
	SimpleStringProperty prodNum;
	SimpleStringProperty description;
	SimpleDoubleProperty price;
	
	public Coffee(String prodNum, String description, double price) {
		super();
		this.prodNum = new SimpleStringProperty(prodNum);
		this.description = new SimpleStringProperty(description);
		this.price = new SimpleDoubleProperty(price);
	}
	
	public SimpleStringProperty prodNumProperty(){
		return prodNum;
	}
	
	public SimpleStringProperty descriptionProperty(){
		return description;
	}
	
	public SimpleDoubleProperty priceProperty(){
		return price;
	}
	
	public void setPrice(double price){
		this.price.set(price);
	}
	
	public void update(){
		
	}
	
	public void insert(){
		
	}
	
}
