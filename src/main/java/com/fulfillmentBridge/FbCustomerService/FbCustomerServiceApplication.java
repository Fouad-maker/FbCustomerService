package com.fulfillmentBridge.FbCustomerService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.fulfillmentBridge.FbCustomerService.dao.CustomerRepo;
import com.fulfillmentBridge.FbCustomerService.entity.Customer;




@SpringBootApplication
public class FbCustomerServiceApplication {
	
	public static void main(String[] args) {
		

		
		SpringApplication.run(FbCustomerServiceApplication.class, args);
	}
	
	
	
	@Bean
	CommandLineRunner start(CustomerRepo customerRepo , RepositoryRestConfiguration repositoryRestConfiguration) {
		return args -> { 
			repositoryRestConfiguration.exposeIdsFor(Customer.class);
			customerRepo.save(new Customer(null,"Fouad","fou216@est.com"));
			customerRepo.save(new Customer(null,"Fluki","fluki@est.com"));
			customerRepo.save(new Customer(null,"Alphy","alphy@est.com"));
			customerRepo.findAll().forEach(p -> {
				System.out.println(p.toString());
			});

			
		};
	}
	
	

}
