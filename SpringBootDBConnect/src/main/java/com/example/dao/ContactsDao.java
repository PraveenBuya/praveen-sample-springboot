/**
 * 
 */
package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Contact;

/**
 * @author praveen
 *
 */
@Repository
public interface ContactsDao extends JpaRepository<Contact, Integer>{

}
