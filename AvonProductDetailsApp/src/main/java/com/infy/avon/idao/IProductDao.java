/**
 * 
 */
package com.infy.avon.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.avon.model.Product;

/**
 * @author praveen
 *
 */
public interface IProductDao extends JpaRepository<Product, Long>{

}
