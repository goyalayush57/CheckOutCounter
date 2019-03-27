package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cart.POJO.Views;
import com.cart.service.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@GetMapping("/test")
	public String test() {
		return "Spring Application is working fine";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
	public String getProductList(){
		String response = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			response = objectMapper.writerWithView(Views.Product.class)
					.withDefaultPrettyPrinter()
					.writeValueAsString(cartService.getAllProductList());
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return response;  
	}
	
	@RequestMapping(value = "/detailedBill", method = RequestMethod.GET, produces = "application/json")
	public String getDetailedBill() {
		String response = null;
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			response = objectMapper.writerWithView(Views.Bill.class)
					.withDefaultPrettyPrinter()
					.writeValueAsString(cartService.getDetailedBill());
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	
}
