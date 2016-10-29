/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person getPersonById(@PathVariable Integer id) {
		return personService.findOne(id);
	}
}
