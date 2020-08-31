package com.worldhospital.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DoctorAppointmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorAppointmentsApplication.class, args);
	}
	
	 @Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurer() {
	    	  
	    	  @Override
	    	  public void addCorsMappings(CorsRegistry registry) {
	    		  registry.addMapping("/**")
	    		  .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	    		  .allowedHeaders("*")
	    		  .allowedOrigins("*");
	    	  }
		};
	   }

}
