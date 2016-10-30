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

import com.example.model.Contact;
import com.example.service.ContactService;

/**
 * @author praveen
 *
 */
@RestController
@RequestMapping(value="/contact")
public class ContactsController {

	@Autowired
	ContactService contactService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Contact> getAllContacts(){
		System.out.println("Inside get all contacts");
		return contactService.getAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Contact getPersonById(@PathVariable Integer id) {
		return contactService.findOne(id);
	}
	
}
