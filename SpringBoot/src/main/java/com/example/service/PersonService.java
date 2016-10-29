/**
 * 
 */
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Idao.IPersonDao;
import com.example.Iservice.IPersonService;
import com.example.entity.Person;

/**
 * @author praveen
 *
 */
@Service
@Transactional

public class PersonService implements IPersonService {
	@Autowired
	IPersonDao personDao;

	@Override
	public List<Person> findAll() {
		return personDao.findAll();
	}

	@Override
	public Person findOne(long id) {
		return personDao.findOne(id);
	}

}
