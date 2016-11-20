package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.PolicyService;

@RestController
public class PolicyController {
	
public static final String URL = "/policy/{policyNumber}";

@Autowired
PolicyService policySerive;

@RequestMapping(URL)
public String getPolicy(@PathVariable final int policyNumber){
	return policySerive.getPolicy(policyNumber);
	
	
}
}
