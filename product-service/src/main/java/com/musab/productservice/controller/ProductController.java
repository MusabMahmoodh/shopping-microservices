package com.musab.productservice.controller;

import com.musab.productservice.dto.NewProductRequest;
import com.musab.productservice.dto.NewProductResponse;
import com.musab.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

  private final ProductService productService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public NewProductResponse createProduct(
      @RequestBody NewProductRequest newProductRequest
  ) {
    return productService.createProduct(newProductRequest);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<NewProductResponse> getAllProduct() {
    return productService.getAllProducts();
  }
}
