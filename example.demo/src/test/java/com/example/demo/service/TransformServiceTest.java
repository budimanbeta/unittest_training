package com.example.demo.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.example.demo.entity.Person;

public class TransformServiceTest {
	private TransformService testClass = new TransformService() ;
	
	 @Test
	    public void test_toDomain() {
	        Person person = new Person();
	        person.setCompanyName("test company");
	        person.setfName("Joko");
	        person.setlName("Widodo");
	        person.setmName("Jokowi");
	        person.setPersonId(1);
	        User user = testClass.toUserDomain(person);
	 
	        assertNotNull(user);
	        assertEquals(user.getCompanyName(), "test company");
	        assertEquals(user.getFirstName(), "Joko");
	        assertEquals( user.getLastName(), "Widodo");
	        assertEquals(user.getUserId().intValue(), 1);
	    }
	 
	    @Test
	    public void test_toEntity() {
	        User user = new User();
	 
	        user.setCompanyName("test company");
	        user.setFirstName("Susilo");
	        user.setLastName("Yudhoyono");
	        user.setUserId(Integer.valueOf(1));
	 
	        Person person = testClass.toUserEntity(user);
	 
	        assertNotNull(user);
	        assertEquals(person.getCompanyName(),"test company");
	        
	        assertEquals( person.getfName(), "Susilo");
	        assertEquals(person.getlName(), "Yudhoyono");
	        assertEquals(person.getPersonId(),1);
	    }
	    
	    
}
