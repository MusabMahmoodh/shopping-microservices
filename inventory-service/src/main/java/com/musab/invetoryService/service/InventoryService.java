package com.musab.invetoryService.service;

import com.musab.invetoryService.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

  private InventoryRepository inventoryRepository;

  @Transactional(readOnly = true)
  public boolean isAvailable(
      String productCode
  ) {
    return inventoryRepository
        .findByByOrderNumber(productCode).isPresent();
  }

}
