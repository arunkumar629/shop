package com.arun.shop.controller;

import java.io.IOException;
import java.io.InputStream;
//import con.arun.shop.dao.*;
//import con.arun.shop.entity.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.shop.dao.ProductRepository;
import com.arun.shop.entity.Product;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping
	public List<Product> getProducts() {
		System.out.println("In product controller");
		List<Product> products = (List<Product>) productRepository.findAll();
		return products;
	}

	//Separate controller for Approach 2
	@GetMapping(value = "image/{pid}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getProductImage(@PathVariable Integer pid) throws IOException {
		InputStream in = getClass().getResourceAsStream("/user-photos/" + pid + "/laptop.jpg");
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(StreamUtils.copyToByteArray(in));

	}

}
