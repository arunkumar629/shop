package com.arun.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.shop.dao.OrderRepository;
import com.arun.shop.entity.Orders;
//import com.sun.tools.javac.util.List;
import java.util.List;
@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class OrderController {
	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping
	public List<Orders> getOrders(){
		List<Orders> orders=(List<Orders>)orderRepository.findAll();
		return orders;
	}
	
	

}
