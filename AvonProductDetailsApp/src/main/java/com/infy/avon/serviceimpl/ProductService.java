/**
 * 
 */
package com.infy.avon.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.avon.idao.IProductDao;
import com.infy.avon.iservice.IProductService;
import com.infy.avon.model.Product;


/**
 * @author praveen
 *
 */
@Service
@Transactional

public class ProductService implements IProductService {
	@Autowired
	IProductDao productDao;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Product findOne(long id) {
		// TODO Auto-generated method stub
		return productDao.findOne(id);
	}

	@Override
	public Product save(Product product) {
		return productDao.save(product);
		
	}

	@Override
	public void delete(long id){
		productDao.delete(id);
	}
}
