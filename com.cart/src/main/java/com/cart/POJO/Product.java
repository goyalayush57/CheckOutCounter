package com.cart.POJO;



import java.math.BigDecimal;

import com.cart.utility.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

public class Product implements Comparable<Product>{
	
	private String name;
	private Category type;
	//single item price
	private BigDecimal price;
	private int quantity;
	
	//used at the time of bill calculation //fields not mandatory
	private BigDecimal totalPriceWithoutTax;
	private BigDecimal totalTax;
	private BigDecimal totalPriceToBePaid;
	
	
	public Product(String name, Category type, BigDecimal price,int quantity) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}
	
	@JsonView(Views.Product.class)
	@JsonProperty("Product Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonView(Views.Product.class)
	@JsonProperty("Category")
	public Category getType() {
		return type;
	}
	public void setType(Category type) {
		this.type = type;
	}
	@JsonView(Views.Product.class)
	@JsonProperty("Price/Item")
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@JsonView(Views.Product.class)
	@JsonProperty("Quantity")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@JsonView(Views.Bill.class)
	@JsonProperty("Price")
	public BigDecimal getTotalPriceWithoutTax() {
		return totalPriceWithoutTax;
	}
	public void setTotalPriceWithoutTax(BigDecimal totalPriceWithoutTax) {
		this.totalPriceWithoutTax = totalPriceWithoutTax;
	}
	@JsonView(Views.Bill.class)
	@JsonProperty("Tax")
	public BigDecimal getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}
	@JsonView(Views.Bill.class)
	@JsonProperty("Total with Tax")
	public BigDecimal getTotalPriceToBePaid() {
		return totalPriceToBePaid;
	}
	public void setTotalPriceToBePaid(BigDecimal totalPriceToBePaid) {
		this.totalPriceToBePaid = totalPriceToBePaid;
	}
	
	
	@Override
    public int compareTo(Product otherProduct) {       
        return this.getName().compareTo(otherProduct.getName());
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((totalPriceToBePaid == null) ? 0 : totalPriceToBePaid.hashCode());
		result = prime * result + ((totalPriceWithoutTax == null) ? 0 : totalPriceWithoutTax.hashCode());
		result = prime * result + ((totalTax == null) ? 0 : totalTax.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (type != other.type)
			return false;
		return true;
	}



}
