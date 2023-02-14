package com.musab.invetoryService.repository;

import com.musab.invetoryService.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{
  Optional<Inventory> findByByOrderNumber(String orderNumber);
}
