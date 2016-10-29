/**
 * 
 */
package com.example.component;

import com.example.exceptionmodel.CustomException;

/**
 * @author praveen
 *
 */
public class ExceptionThrower {
	
	public void throwGeneralException() throws Exception{
		Exception e = new Exception ("Error from general exception");
		throw e;
	}

	
	public void throwCustomException() throws CustomException{
		CustomException e = new CustomException ();
		e.setCode(10);
		e.setMessage("First name not provided");
		throw e;
	}
}
