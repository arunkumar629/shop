package com.arun.shop.controller;
import com.arun.shop.entity.*;
import com.arun.shop.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserDaoImpl userDao;

	@GetMapping
	public List<User> getUsers(){
		return userDao.findAll();
	}
}