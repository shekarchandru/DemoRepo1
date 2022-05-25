package com.cognizant.e_FurnitureMakerWageCalciRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class},scanBasePackages= {"com.cognizant.controller","com.cognizant.model","com.cognizant.dao","com.cognizant.service"})
public class EFurnitureMakerWageCalciRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EFurnitureMakerWageCalciRestApiApplication.class, args);
	}

}
