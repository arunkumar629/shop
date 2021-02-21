package com.arun.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.shop.dao.UserAccountRepository;
import com.arun.shop.entity.UserAccount;

@RestController
@RequestMapping("/userAccount")
@CrossOrigin(origins = "*")
public class UserAccountController {
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
@GetMapping
public List<UserAccount> getUserAccount(){
List<UserAccount> userAccounts=(List<UserAccount>)userAccountRepository.findAll();
return userAccounts;
}

@PostMapping
public void saveUserAccount(@RequestBody UserAccount userAccount) {
	userAccountRepository.save(userAccount);
}
	
}
