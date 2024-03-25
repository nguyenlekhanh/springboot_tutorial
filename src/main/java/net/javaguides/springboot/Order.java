package net.javaguides.springboot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
	@JsonProperty("c-name")
	private String customerName;
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("p-name")
	private String productName;
	
	@JsonProperty("quantity")
	private String quantity;
	
	@Override
	public String toString() {
		return "Order{" +
				"customerName='" + customerName + '\'' +
				"productName='" + productName + '\'' +
				"customerName='" + quantity +
				'}';
	}
}
