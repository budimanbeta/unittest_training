package com.example.demo.service;

import java.util.List;

public interface UserService {
	
	void deleteById(Integer personId);
	User findById(Integer personId);
	User save(User user);
	List searchByCompanyName(String companyName);
}
