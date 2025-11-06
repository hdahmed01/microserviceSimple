package com.ahmed.inventoryservice;

import com.ahmed.inventoryservice.entity.Product;
import com.ahmed.inventoryservice.repo.InventoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner run(InventoryRepo repo) {
		return args -> {
			repo.save(Product.builder().id(UUID.randomUUID().toString()).name("Pc").build());
			repo.save(Product.builder().id(UUID.randomUUID().toString()).name("Phone").build());

		};
	}
}
