package com.example.demo.service;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.demo.entity.Person;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.impl.UserServiceImpl;

public class MockUserServiceImplTest {
	private static final String UNYIL = "Unyil";
	private static final String TEST_COMPANY = "Test";

	private Person person = new Person();
	private User user = new User();

	
	@Mock
	private UserServiceImpl userService;

	@BeforeClass
	public void init_test() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeMethod
	public void setup_data() {
		person.setfName(UNYIL);
		user.setFirstName(UNYIL);
	}

	@Test
	public void findById_found() {
		//doReturn(user).when(userService).findById(Integer.valueOf(1));
		when(userService.findById(Integer.valueOf(1))).thenReturn(user);
		
		User user = userService.findById(1);

		assertEquals(user.getFirstName(), UNYIL);

	}

	@Test(expectedExceptions = UserNotFoundException.class)
	public void findById_not_found() {
	//	doThrow(UserNotFoundException.class).when(userService).findById(Integer.valueOf(12));
		when(userService.findById(Integer.valueOf(12))).thenThrow(UserNotFoundException.class);

		userService.findById(Integer.valueOf(12));
	}

	@Test
	public void searchByCompanyName_found() {
		List<User> users = new ArrayList<>();
		users.add(user);
		//doReturn(users).when(userService).searchByCompanyName(TEST_COMPANY);
		when(userService.searchByCompanyName(TEST_COMPANY)).thenReturn(users);
		
		List<User> usersReturn = userService.searchByCompanyName(TEST_COMPANY);
		assertEquals(usersReturn.size(), 1);
		assertEquals(usersReturn.get(0).getFirstName(), UNYIL);
	}

	

	

}
