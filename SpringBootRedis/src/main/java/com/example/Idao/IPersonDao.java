/**
 * 
 */
package com.example.Idao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Person;

/**
 * @author praveen
 *
 */
public interface IPersonDao extends JpaRepository<Person, Long>{

}
