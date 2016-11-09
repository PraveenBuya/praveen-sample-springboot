/**
 * 
 */
package com.infy.avon.iservice;

import java.util.List;

import com.infy.avon.model.Product;


/**
 * @author praveen
 *
 */
public interface IProductService {

	List<Product> findAll();

	Product findOne(long id);

	Product save(Product product);

	void delete(long id);

}
