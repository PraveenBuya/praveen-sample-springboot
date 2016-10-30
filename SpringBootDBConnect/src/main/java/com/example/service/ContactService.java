/**
 * 
 */
package com.example.service;

import java.util.List;

import com.example.model.Contact;

/**
 * @author praveen
 *
 */

public interface ContactService {

	public List<Contact> getAll();

	public Contact findOne(Integer id);
}
