package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.TransformService;
import com.example.demo.service.User;
import com.example.demo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
    private PersonRepository personDao;
 
    @Autowired
    private TransformService transformer;
    
    
    public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
    
    
    public UserServiceImpl(PersonRepository personDao, TransformService transformer) {
		this.personDao = personDao;
		this.transformer = transformer;
	}


	@Override
    public void deleteById(Integer personId) {
        personDao.deleteById(personId);
    }
 
    @Override
    public User findById(Integer personId) {
        Person found = personDao.findOne(personId);
 
        if (found ==null) {
            throw new UserNotFoundException("not found user", personId);
        }
        return transformer.toUserDomain(found);
    }
 
    @Override
    public User save(User user) {
        Person saved = personDao.save(transformer.toUserEntity(user));
        return transformer.toUserDomain(saved);
    }
 
    @Override
    public List<User> searchByCompanyName(String companyName) {
        List<Person> persons = personDao.findByCompany(companyName);
        List<User> users = new ArrayList<>();
        for (Person person : persons) {
            users.add(transformer.toUserDomain(person));
        }
        return users;
    }
}
