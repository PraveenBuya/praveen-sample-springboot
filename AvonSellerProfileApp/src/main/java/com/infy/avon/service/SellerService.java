package com.infy.avon.service;

import java.sql.SQLException;
import java.util.List;

import com.infy.avon.bean.Seller;

public interface SellerService {

	
	public Seller createSeller(Seller seller) throws SQLException;
	
	public List<Seller> getSellers();

	public Seller findSellerById(int id);

	public void updateSeller(Seller seller) throws SQLException;
}
