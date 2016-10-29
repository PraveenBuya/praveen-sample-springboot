/**
 * 
 */
package com.example.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.component.ExceptionThrower;
import com.example.model.CustomerAccount;

/**
 * @author praveen
 *
 */
@RestController
@RequestMapping("/customermaintenance")
public class CustomerMaintenanceController {

	@Autowired
	CustomerAccount customerAccount;

	@RequestMapping(path = "/getaccountbasic", method = RequestMethod.GET)
	public ResponseEntity<CustomerAccount> getAccount() throws Exception {

		customerAccount.setCustomerId(123);
		customerAccount.setFirstName("TestFirstName");
		customerAccount.setLastName("TestLastName");

		return new ResponseEntity<CustomerAccount>(customerAccount, HttpStatus.OK);

	}

	@RequestMapping(path = "/createaccount", method = RequestMethod.POST)
	public ResponseEntity<CustomerAccount> createAccount(@RequestBody CustomerAccount inputCustomerAccount)
			throws Exception {
		System.out.println(inputCustomerAccount.getCustomerId());

		//ExceptionThrower eT = new ExceptionThrower();
		//eT.throwCustomException();
		//eT.throwGeneralException();
		
		return new ResponseEntity<CustomerAccount>(inputCustomerAccount, HttpStatus.OK);

	}

}
