package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class PolicyService {

	public String getPolicy(final int policyNumber){
		return policyNumber > 5 ? "philip" : "tesing";
	}
}
