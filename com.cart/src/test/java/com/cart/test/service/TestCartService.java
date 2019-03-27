package com.cart.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cart.POJO.Product;
import com.cart.service.CartService;
import com.cart.utility.Category;

@SpringBootTest
public class TestCartService {
	
	
	
	@Autowired
	CartService cartService;
	
	List<Product> defaultProductList;
	@BeforeEach
	public void init() { 
			defaultProductList = new ArrayList<>();
			defaultProductList.add(new Product("Adidas Shoe",Category.A,BigDecimal.valueOf(1335),2));
			defaultProductList.add(new Product("Creme",Category.A,BigDecimal.valueOf(132),1));
			defaultProductList.add(new Product("Belt",Category.C,BigDecimal.valueOf(124434),4));
			defaultProductList.add(new Product("Tie",Category.A,BigDecimal.valueOf(1343.12),1));
			defaultProductList.add(new Product("Denim Shirt",Category.B,BigDecimal.valueOf(2343.34),1));
			defaultProductList.add(new Product("Razor",Category.C,BigDecimal.valueOf(2234),2));
		
	}
	
	
	
	
	@Test
	void getAllProductList() {
		
		assertEquals(defaultProductList.size(),cartService.getAllProductList().size());
		assertTrue("List is not coming as per default list",is(cartService.getAllProductList()));
		
	}
	
	private boolean is(List<Product> defaultProductList2) {
		for(Product p:defaultProductList) {
			if(!defaultProductList2.contains(p))return false;
		}
		return true;
	}




	@Test
	public void getDetailedBill() {
		assertTrue(cartService.getDetailedBill().getAmountToBepaid().toPlainString().equals("509575.640"));
		assertTrue(cartService.getDetailedBill().getPriceWithoutTax().toPlainString().equals("508692.46"));
		assertTrue(cartService.getDetailedBill().getTotalTax().toPlainString().equals("883.180"));
	}

}
