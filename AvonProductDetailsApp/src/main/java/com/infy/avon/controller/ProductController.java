/**
 * 
 */
package com.infy.avon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.avon.iservice.IProductService;
import com.infy.avon.model.Product;

/**
 * @author praveen
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	IProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Cacheable("product")
	public List<Product> listPersons() {
		return productService.findAll();
	}

	/*
	 * Putting @Cacheable annotation on a method will cause it's results to be
	 * cached in Redis database
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Cacheable(value = "product", key = "#id")
	public Product getProductById(@PathVariable Integer id) {
		System.out.println("-----------------Inside getPersonById  controller -----------------------------");
		return productService.findOne(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return productService.save(product);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	@CachePut(value = "product", key = "#id")
	public Product updateProduct(@PathVariable Integer id,@RequestBody Product products) {
		return productService.save(products);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@CacheEvict(value = "product", key = "#id")
	public void deleteProduct(@PathVariable Integer id) {
		productService.delete(id);
	}
}
