package com.infy.avon.controller;

import java.sql.SQLException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.avon.bean.Seller;
import com.infy.avon.service.SellerService;

@RestController
@RequestMapping("/sellerProfile")
public class SellerRegistrationController {

	private static final Logger log = LoggerFactory.getLogger(SellerRegistrationController.class);
	
	@Autowired
	SellerService sellerService;
	
	
	
	/**
	 * saveSellerDetails
	 * 
	 * @param seller
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value ="/save", method=RequestMethod.POST)
	public String submitSellerProfile(@RequestBody Seller seller) throws SQLException{
		log.info("submitSellerProfile..");
		
		try{
			
				Seller s = sellerService.createSeller(seller);
				
				if(s.getFirstName()!= null )
					return "Success!!";
				
		}catch(Exception e){
				e.printStackTrace();
		}
		
		return "Failure!!";
	}
	
	
	/**
	 * updateSellerDetails
	 * 
	 * @param seller
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value ="/update", method=RequestMethod.PUT)
	public void updateSellerProfile(@RequestBody Seller seller) throws SQLException{
		log.info("updateSellerProfile..");
		
		seller = sellerService.findSellerById(seller.getId());
		
		if(seller.getId()!= 0 )
		sellerService.updateSeller(seller);
		
		//return "Success!!";
	}
	
	
	
	/**
	 * getSellers
	 * @return
	 */
	@RequestMapping(value ="/list", method=RequestMethod.GET)
	public Collection<Seller>getSellers() {
		
		return sellerService.getSellers();
	}
	
	
	/**
	 * findSellerById
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value ="/get/{id}", method=RequestMethod.GET)
	public Seller findSellerById(@PathVariable("id") int id) {
		Seller seller = null;
		try{
			
			 seller = sellerService.findSellerById(id);
			if(seller.getFirstName()!= null )
				return seller;
				
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return seller;
	}
	
}
