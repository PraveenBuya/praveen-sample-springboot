package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.avon.AvonSellerProfileAppApplication;
import com.infy.avon.bean.Seller;
import com.infy.avon.dao.SellerDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringApplicationConfiguration(AvonSellerProfileAppApplication.class)
public class AvonSellerProfileAppApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(AvonSellerProfileAppApplicationTests.class);

	@Autowired
	private SellerDao sellerDao;


	@Test
	public void contextLoads() {
	}


	@Test
	public void findAllSellers()  {
		log.info(":::::::::::::::::::::::::::::::::::::::::");
		log.info("<< Start findAllSellers TestMethod() >>");
		List<Seller> sellers = sellerDao.findAllSellers();
		log.info("::sellers Size::" +sellers.size());

		for(int i=0;i<sellers.size();i++)
			log.info("Seller Data::" +sellers.get(i));

		assertNotNull(sellers);
		assertTrue(!sellers.isEmpty());
		log.info("<< End findAllSellers TestMethod() >>");
		log.info(":::::::::::::::::::::::::::::::::::::::::");

	}

	@Test
	public void findSellerById()  {
		log.info(":::::::::::::::::::::::::::::::::::::::::");
		log.info("<< Start findSellerById TestMethod() >>");
		Seller seller = sellerDao.findSellerById(1);
		log.info(":::::findSellerById::::" +seller);
		assertNotNull(seller);
		log.info("<< End findSellerById TestMethod() >>");
		log.info(":::::::::::::::::::::::::::::::::::::::::");
	}

	@Test
	public void createUser() throws SQLException {
		log.info(":::::::::::::::::::::::::::::::::::::::::");
		log.info("<< Start createUser TestMethod() >>");
		Seller seller = new Seller(6, "amar", "y", "amar.hani@gmail.com","9876541235");
		Seller savedUser = sellerDao.createSeller(seller);
		log.info(":::::savedUser::::" +savedUser);
		Seller newUser = sellerDao.findSellerById(savedUser.getId());
		assertEquals("amar", newUser.getFirstName());
		assertEquals("amar.hani@gmail.com", newUser.getEmailId());
		log.info("<< End createUser TestMethod() >>");
		log.info(":::::::::::::::::::::::::::::::::::::::::");
	}

	@Test
	public void updateUser() throws SQLException {
		log.info(":::::::::::::::::::::::::::::::::::::::::");
		log.info("<< Start updateUser TestMethod() >>");
		Seller seller = new Seller(6, "amar", "y", "amar.hani@gmail.com","9876541235");
		Seller savedSeller = sellerDao.createSeller(seller);

		Seller newSellerDetails = sellerDao.findSellerById(savedSeller.getId());
		log.info(":::::newSellerDetails::::" +newSellerDetails);

		Seller seller1 = new Seller(newSellerDetails.getId(), "Amarnath Reddy", "YB", "amar.hani@gmail.com","9876541235");
		sellerDao.updateSeller(seller1);
		
		Seller updatedSellerDetails = sellerDao.findSellerById(newSellerDetails.getId());
		log.info(":::::updatedSellerDetails::::" +updatedSellerDetails);

		assertEquals("Amarnath Reddy", updatedSellerDetails.getFirstName());
		assertEquals("amar.hani@gmail.com", updatedSellerDetails.getEmailId());
		log.info("<< End updateUser TestMethod() >>");
		log.info(":::::::::::::::::::::::::::::::::::::::::");
	}
}
