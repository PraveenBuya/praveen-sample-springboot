package com.infy.avon.dao;

import java.sql.SQLException;
import java.util.List;

import com.infy.avon.bean.Seller;

public interface SellerDao {

	
	public Seller createSeller(Seller seller) throws SQLException;
	public void updateSeller(Seller seller) throws SQLException;
	public List<Seller> findAllSellers();
	public Seller findSellerById(int id);
		
	
}


