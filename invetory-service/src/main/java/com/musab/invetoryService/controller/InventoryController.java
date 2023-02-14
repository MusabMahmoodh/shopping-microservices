package com.musab.invetoryService.controller;

import com.musab.invetoryService.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventories")
@RequiredArgsConstructor
public class InventoryController {


  private final InventoryService inventoryService;

  @GetMapping("/{product-code}")
  @ResponseStatus(HttpStatus.OK)
  public boolean isInventoryAvailable(
    @PathVariable("product-code") String productCode
  ) {
    return inventoryService
        .isAvailable(productCode);
  }

}
