package com.example.demo.service;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.example.demo.exception.UserNotFoundException;


@SpringBootTest
public class UserServiceIntegrationTest  extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserService userService;
    
    @Test(expectedExceptions  = UserNotFoundException.class)
    public void findById_throw_exception_when_not_found() {
        userService.findById(Integer.valueOf(-1));
    }
    
    @Test
    public void searchByCompanyName_return_empty_when_not_found() {
        List<User> found = userService.searchByCompanyName("Test");
        assertTrue(found.isEmpty());
    }
    
    @Test
    public void test_save_findById_searchByCompanyName() {
        User user = new User();
        user.setFirstName("Mary");
        user.setLastName("Zheng");
        user.setCompanyName("Test");
        user = userService.save(user);
        assertNotNull(user.getUserId());
 
        User foundUser = userService.findById(user.getUserId());
        assertTrue(foundUser.equals(user));
        userService.deleteById(user.getUserId());
 
        List<User> found = userService.searchByCompanyName("Test");
        assertTrue(found.isEmpty());
    }
    
}
