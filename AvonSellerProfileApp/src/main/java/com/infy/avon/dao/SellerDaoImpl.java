package com.infy.avon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infy.avon.bean.Seller;



@Repository
public class SellerDaoImpl implements SellerDao{
	private static final Logger log = LoggerFactory.getLogger(SellerDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * FindAllSellers
	 * @return 
	 * 
	 */
	@Transactional(readOnly=true)
	public List<Seller> findAllSellers() {
		return jdbcTemplate.query("select * from Seller", new UserRowMapper());		
	}
	
	
	
	/**
	 * FindSellerById
	 * @param id
	 * @return 
	 */
	@Transactional(readOnly=true)
	public Seller findSellerById(int id) {
		return jdbcTemplate.queryForObject("select * from Seller where id=?", new Object[]{id}, new UserRowMapper());
	}


	
	/**
	 * createSeller 
	 * @return
	 */
	public Seller createSeller(Seller seller) {
		log.info("DaoImpl::createSeller::seller::" +seller);
		final String sql = "insert into Seller(firstName,lastName,emailId,contactNumber) values(?,?,?,?)";
		
		KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {           

                @Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, seller.getFirstName());
                    ps.setString(2, seller.getLastName());
                    ps.setString(3, seller.getEmailId());
                    ps.setString(4, seller.getContactNumber());
                    
                    return ps;
                }
            }, holder);

		int newUserId = holder.getKey().intValue();
		seller.setId(newUserId);		
		return seller;
	}
	
	
	/**
	 * updateSeller 
	 * @param seller
	 */
	public void updateSeller(Seller seller) {
		log.info("<<DaoImpl::updateSeller::seller::>>" +seller);
		
		
				
		 String query = "update Seller set firstName=?,lastName=?,emailId=?,contactNumber=? where id=?";
		 
		 jdbcTemplate.update(query,
	                new Object[] { 
	                		seller.getFirstName(),seller.getLastName(),seller.getEmailId(),seller.getContactNumber(),Integer.valueOf(seller.getId()) 
	                        });
		 
		
	}

	class UserRowMapper implements RowMapper<Seller>
	{

		@Override
		public Seller mapRow(ResultSet rs, int rowNum) throws SQLException {
			Seller seller = new Seller();
			seller.setId(rs.getInt("id"));
			seller.setFirstName(rs.getString("firstName"));
			seller.setLastName(rs.getString("lastName"));
			seller.setEmailId(rs.getString("emailId"));
			seller.setContactNumber(rs.getString("contactNumber"));
			
			return seller;
		}
		
	}

	

}
