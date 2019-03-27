package com.cart.test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cart.controller.CartController;

@SpringBootTest
class CartControllerTest {
	

	@Autowired
	CartController cartController;
	
	String defaultUri;
	
	@BeforeEach
	void init() {
		defaultUri = "https://localhost:8080/cart/";
	}
	
	@Test
	void getProductList() {
	
	}
	
	@Test
	void getDetailedBill() {
		
	}

}
