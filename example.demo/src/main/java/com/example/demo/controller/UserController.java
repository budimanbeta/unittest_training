package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/api/user/{id}")
	public User getUserFromService() {
		
		return userService.findById(1);
	}
	@GetMapping("/api/test/{id}")
	public User getUser() {
	  	return new User(1,"Donald","Duck","Disney");
	}
	
	
}
