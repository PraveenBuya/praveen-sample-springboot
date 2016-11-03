/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Iservice.IPersonService;
import com.example.entity.Person;

/**
 * @author praveen
 *
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	IPersonService personService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Person> listPersons() {
		return personService.findAll();
	}

	/*
	 * Putting @Cacheable annotation on a method will cause it's results to be cached in  Redis database
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 @Cacheable(value = "person", key = "#id")
	public Person getPersonById(@PathVariable Integer id) {
		System.out.println("-----------------Inside getPersonById  controller -----------------------------");
		return personService.findOne(id);
	}
}
