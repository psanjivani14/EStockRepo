package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.cts.estock.jwtfilter.SecurityFilter;

@SpringBootApplication
public class EStockMarketApplication {

	@Bean
	public FilterRegistrationBean jwtFiler() {
		FilterRegistrationBean obj = new FilterRegistrationBean();
		obj.setFilter(new SecurityFilter());
		obj.addUrlPatterns("/api/v1/*");
		return obj;
	}
	public static void main(String[] args) {
		SpringApplication.run(EStockMarketApplication.class, args);
	}

}
