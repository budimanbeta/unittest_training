package com.example.demo.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.demo.entity.Person;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.impl.UserServiceImpl;

public class MockDependenciesUserServiceImplTest {
	private static final String UNYIL = "Unyil";
	private static final String TEST_COMPANY = "Test";

	private Person person = new Person();
	private User user = new User();

	@Mock
	private PersonRepository personDao;
	@Mock
	private TransformService transformer;

	@InjectMocks
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
		doReturn(person).when(personDao).findOne(Integer.valueOf(1));
		doReturn(user).when(transformer).toUserDomain(person);

		User user = userService.findById(1);

		assertEquals(user.getFirstName(), UNYIL);

	}

	@Test(expectedExceptions = UserNotFoundException.class)
	public void findById_not_found() {
		doReturn(null).when(personDao).findOne(Integer.valueOf(1));

		userService.findById(Integer.valueOf(1));
	}

	@Test
	public void searchByCompanyName_found() {
		List<Person> persons = new ArrayList<>();
		persons.add(person);
		doReturn(persons).when(personDao).findByCompany(TEST_COMPANY);
		doReturn(user).when(transformer).toUserDomain(person);

		List<User> users = userService.searchByCompanyName(TEST_COMPANY);
		assertEquals(users.size(), 1);
		assertEquals(users.get(0).getFirstName(), UNYIL);
	}

	@Test
	public void searchByCompanyName_not_found() {
		List<Person> persons = new ArrayList<>();
		doReturn(persons).when(personDao).findByCompany(TEST_COMPANY);
		doReturn(user).when(transformer).toUserDomain(person);

		List<User> users = userService.searchByCompanyName(TEST_COMPANY);
		assertTrue(users.isEmpty());
	}

	@Test
	public void deleteById_is_done_by_dao_delete() {
		doNothing().when(personDao).deleteById(Mockito.anyInt());

		userService.deleteById(Integer.valueOf(1));

		verify(personDao, times(1)).deleteById(Integer.valueOf(1));
	
	}

	

}
