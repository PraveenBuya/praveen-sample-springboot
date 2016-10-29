/**
 * 
 */
package com.example.controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Contract;
import com.example.repository.ContractRepository;

/**
 * @author praveen
 *
 */
@RestController
@RequestMapping(ContractController.CONTRACT_BASE_URI)
public class ContractController {
	
	public static final String CONTRACT_BASE_URI = "/contracts";
	
	@Autowired
	private ContractRepository contractRepository;
	
	@RequestMapping(value= "{contractNumber}")
	public Contract getContract(@PathVariable final int contractNumber){
		return contractRepository.get(contractNumber);
		
	}
	
	

}
