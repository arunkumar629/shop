package com.arun.shop.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.shop.dao.UserRepository;
import com.arun.shop.entity.User;
@RestController
@RequestMapping("/user")
@CrossOrigin(origins ="*")
//@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping
	public List<User> getUsers(){
		List<User> users=(List<User>)userRepository.findAll();
		return users;
	}


@PostMapping
public void saveUser(@RequestBody User user) {
userRepository.save(user);	
}
}