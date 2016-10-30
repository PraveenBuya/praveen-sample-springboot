/**
 * 
 */
package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ContactsDao;
import com.example.model.Contact;
import com.example.service.ContactService;

/**
 * @author praveen
 *
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	ContactsDao contactDao;

	@Override
	//@Transactional(propagation = Propagation.REQUIRED)
	public List<Contact> getAll() {
		// TODO Auto-generated method stub
		return contactDao.findAll();
	}

	@Override
	public Contact findOne(Integer id) {
		// TODO Auto-generated method stub
		return contactDao.findOne(id);
	}

}
