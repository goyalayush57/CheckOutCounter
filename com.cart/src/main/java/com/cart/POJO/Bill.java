package com.cart.POJO;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bill {

	private List<Product> products;
	private BigDecimal totalTax;
	private BigDecimal priceWithoutTax;
	private BigDecimal amountToBepaid;
	
	public Bill(List<Product> products, BigDecimal totalTax, BigDecimal priceWithoutTax, BigDecimal amountToBepaid) {
		super();
		this.products = products;
		this.totalTax = totalTax;
		this.priceWithoutTax = priceWithoutTax;
		this.amountToBepaid = amountToBepaid;
	}
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@JsonProperty("Total Tax")
	public BigDecimal getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}
	@JsonProperty("Total Price")
	public BigDecimal getPriceWithoutTax() {
		return priceWithoutTax;
	}
	public void setPriceWithoutTax(BigDecimal priceWithoutTax) {
		this.priceWithoutTax = priceWithoutTax;
	}
	@JsonProperty("Total Amount to be Paid")
	public BigDecimal getAmountToBepaid() {
		return amountToBepaid;
	}
	public void setAmountToBepaid(BigDecimal amountToBepaid) {
		this.amountToBepaid = amountToBepaid;
	}

	
	
}
