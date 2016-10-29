/**
 * 
 */
package com.example.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.model.Contract;

/**
 * @author praveen
 *
 */
@Repository
public class ContractRepository {

	private Logger logger = LoggerFactory.getLogger(ContractRepository.class);

	public Contract get(final int contractNumber) {

		Contract contract = new Contract();
		contract.setContractNumber(contractNumber);
		contract.setName("TestContract");
		logger.info("Loaded contact ({}) from repository : {}", contractNumber, contract);
		throw new IllegalStateException();
		//return contract;

	}

}
