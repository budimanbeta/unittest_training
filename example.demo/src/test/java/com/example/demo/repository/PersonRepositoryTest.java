package com.example.demo.repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.demo.entity.Person;


@DataJpaTest
public class PersonRepositoryTest extends AbstractTestNGSpringContextTests {
	
   
    @Autowired
    private PersonRepository personDao;
    
    @BeforeClass
    public void personDao_initialize() {
    	assertNotNull(personDao);
    }
    
    
    @BeforeMethod
    public void personDao_setup_data() {
      
        // prepare two persons
        Person unyil = new Person();
        unyil.setfName("Unyil");
        unyil.setCompanyName("Test");
        personDao.save(unyil);
 
        Person usro = new Person();
        usro.setfName("Usro");
        usro.setCompanyName("Usro company");
        
        personDao.save(usro);
 
    }
  
    
    @Test
    public void findAll_return_list_when_found() {
        List<Person> found = personDao.findAll();
 
        assertNotNull(found);
        assertEquals(found.size(),2);
    }
    
    @Test
    public void findByCompany_return_person_when_found() {
        List<Person> found = personDao.findByCompany("Test");
 
        assertNotNull(found);
        assertEquals( found.get(0).getfName(),"Unyil");
    }
    
    @Test
    public void findByCompany_return_emptylist_when_not_found() {
        List<Person> found = personDao.findByCompany("Test-notExist");
 
        assertNotNull(found);
        assertTrue(found.isEmpty());
 
    }
    
    
}
