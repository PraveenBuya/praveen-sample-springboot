/**
 * 
 */
package com.example.retry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.UniformRandomBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author praveen
 *
 */
@Configuration
public class RetryConfig {
	
	@Bean
	public RetryTemplate createRetryTemplate(){
		
		SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
		retryPolicy.setMaxAttempts(5);
		
		UniformRandomBackOffPolicy backOffPolicy = new UniformRandomBackOffPolicy();
		backOffPolicy.setMinBackOffPeriod(5001);
		backOffPolicy.setMaxBackOffPeriod(30001);
		
		RetryTemplate retryTemplate = new RetryTemplate();
		retryTemplate.setRetryPolicy(retryPolicy);
		retryTemplate.setBackOffPolicy(backOffPolicy);
		return retryTemplate;
		
	}

}
