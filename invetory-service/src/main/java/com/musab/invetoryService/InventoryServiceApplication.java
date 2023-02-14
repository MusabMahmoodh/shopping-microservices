package com.musab.invetoryService;

import com.musab.invetoryService.model.Inventory;
import com.musab.invetoryService.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadInitialData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setProductNumber("123");
			inventory.setQuantity(10);
			inventoryRepository.save(inventory);

			Inventory inventory2 = new Inventory();
			inventory2.setProductNumber("456");
			inventory2.setQuantity(20);
			inventoryRepository.save(inventory2);

			Inventory inventory3 = new Inventory();
			inventory3.setProductNumber("789");
			inventory3.setQuantity(30);
			inventoryRepository.save(inventory3);
		};
	}
}
