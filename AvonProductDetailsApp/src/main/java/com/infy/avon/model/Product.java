/**
 * 
 */
package com.infy.avon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author praveen
 *
 */
@Entity
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name = "prod_Name")
	private String prodName;

	@Column(name = "prod_Price")
	private String prodPrice;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the prodName
	 */
	public String getProdName() {
		return prodName;
	}

	/**
	 * @param prodName
	 *            the prodName to set
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	/**
	 * @return the prodPrice
	 */
	public String getProdPrice() {
		return prodPrice;
	}

	/**
	 * @param prodPrice
	 *            the prodPrice to set
	 */
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}

}
