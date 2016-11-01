package com.avon;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password("secret1").roles("USER").credentialsExpired(true).and().withUser("user2")
				.password("secret2").roles("USER");
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests().anyRequest().fullyAuthenticated();
        http.httpBasic();
        http.csrf().disable();
        http.logout().deleteCookies("JSESSIONID");
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).enableSessionUrlRewriting(false);
        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);  
		 
		/*	http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).enableSessionUrlRewriting(false)
			.and().authorizeRequests().antMatchers("/reeting").permitAll()
			.anyRequest().authenticated();
*/
	
	}
}