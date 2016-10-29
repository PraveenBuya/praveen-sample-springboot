/**
 * 
 */
package com.example.model;

import org.springframework.stereotype.Component;

/**
 * @author praveen
 *
 */
@Component
public class Contract {

	private int contractNumber;
	private String name;
	/**
	 * @return the contractNumber
	 */
	public int getContractNumber() {
		return contractNumber;
	}
	/**
	 * @param contractNumber the contractNumber to set
	 */
	public void setContractNumber(int contractNumber) {
		this.contractNumber = contractNumber;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
