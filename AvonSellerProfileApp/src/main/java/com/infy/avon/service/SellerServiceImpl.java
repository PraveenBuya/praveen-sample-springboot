package com.infy.avon.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.avon.bean.Seller;
import com.infy.avon.dao.SellerDao;

@Service
public class SellerServiceImpl implements SellerService{

	@Autowired
	SellerDao sellerDao;
	
	
	
	/**
	 * createSeller
	 * 
	 * @param seller
	 * @throws SQLException
	 */
	public Seller createSeller(Seller seller) throws SQLException {
		
		return sellerDao.createSeller(seller);
	}
	
	

	/**
	 * getSellers
	 * 
	 * @return
	 */
	public List<Seller> getSellers() {
		
		return sellerDao.findAllSellers();
	}

	
	
	/**
	 * findSellerById
	 * 
	 * @param id
	 * @return
	 */
	public Seller findSellerById(int id) {
		return sellerDao.findSellerById(id);
	}



    /**
     * updateSeller
     * 
     * @param seller
     * @return
     */
	public void updateSeller(Seller seller) throws SQLException {
		 sellerDao.updateSeller(seller);
	}
	
	

}
