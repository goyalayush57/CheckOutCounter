package com.cart.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cart.POJO.Bill;
import com.cart.POJO.Product;
import com.cart.utility.Category;

@Service
public class CartService {

	List<Product> defaultProductList;
	 {
		defaultProductList = new ArrayList<>();
		defaultProductList.add(new Product("Adidas Shoe",Category.A,BigDecimal.valueOf(1335),2));
		defaultProductList.add(new Product("Creme",Category.A,BigDecimal.valueOf(132),1));
		defaultProductList.add(new Product("Belt",Category.C,BigDecimal.valueOf(124434),4));
		defaultProductList.add(new Product("Tie",Category.A,BigDecimal.valueOf(1343.12),1));
		defaultProductList.add(new Product("Denim Shirt",Category.B,BigDecimal.valueOf(2343.34),1));
		defaultProductList.add(new Product("Razor",Category.C,BigDecimal.valueOf(2234),2));
	}
	
	
	public List<Product> getAllProductList(){
		return defaultProductList;
	}
	
	public Bill getDetailedBill() {
		Bill bill;
		BigDecimal totalTax = new BigDecimal(0.0);
		BigDecimal totalPriceWithoutTax = new BigDecimal(0.0);
		BigDecimal amountToBepaid = new BigDecimal(0.0);
		
		for(Product p:defaultProductList) {
			BigDecimal price = p.getPrice().multiply(new BigDecimal(p.getQuantity()));
			p.setTotalPriceWithoutTax(price);
			int taxPercentage = p.getType().getSalesTax();
			p.setTotalTax(price.multiply(new BigDecimal(taxPercentage)).divide(new BigDecimal(100)));
			p.setTotalPriceToBePaid(p.getTotalPriceWithoutTax().add(p.getTotalTax()));
			
			totalTax = totalTax.add(p.getTotalTax());
			totalPriceWithoutTax = totalPriceWithoutTax.add(price);
			amountToBepaid = amountToBepaid.add(p.getTotalPriceToBePaid());
		}
		
		bill = new Bill(defaultProductList,totalTax,totalPriceWithoutTax,amountToBepaid);
		
		
		return bill;
	}
	
	
}
