package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

@Repository
public interface  PersonRepository extends JpaRepository<Person, Integer>  {
	 @Query("SELECT person from Person person WHERE person.companyName = :companyName")
	  List<Person> findByCompany(@Param("companyName") String companyName);
	 
	 @Query("SELECT person from Person person WHERE person.personId = :id")
	  Person findOne(@Param("id") Integer id);
	 
}
