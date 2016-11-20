package com.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.service.PolicyService;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(PolicyController.class)
public class PolicyControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	PolicyService policySerive;
	
	@Test
	public void testpolicyID() throws Exception{
		final int policyNumber = 6;
		
		given(policySerive.getPolicy(policyNumber)).willReturn("philip");
		
		mvc.perform(get(PolicyController.URL,policyNumber).accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk()).andExpect(content().string("philip"));
		
		verify(policySerive,timeout(1)).getPolicy(policyNumber);
	}
	

}
