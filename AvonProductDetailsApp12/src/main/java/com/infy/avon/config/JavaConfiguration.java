//The -webDaemon means run H2 web console in a daemon thread which will not block the application process termination. -webPort can set the web console service port, default is 8082. The web console url is http://localhost:8082 

package com.infy.avon.config;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class JavaConfiguration {
 //... other beans
  
 @Bean(initMethod="start",destroyMethod="stop")
 public org.h2.tools.Server h2WebConsonleServer () throws SQLException {
   return org.h2.tools.Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8086");
 }
}