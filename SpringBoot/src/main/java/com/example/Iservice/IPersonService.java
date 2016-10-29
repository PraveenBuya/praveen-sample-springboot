/**
 * 
 */
package com.example.Iservice;

import java.util.List;

import com.example.entity.Person;

/**
 * @author praveen
 *
 */
public interface IPersonService {

	List<Person> findAll();

	Person findOne(long id);

}
