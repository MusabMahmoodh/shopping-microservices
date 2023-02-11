package com.musab.productservice.service;

import com.musab.productservice.dto.NewProductRequest;
import com.musab.productservice.dto.NewProductResponse;
import com.musab.productservice.model.Product;
import com.musab.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

  private final ProductRepository productRepository;

  public NewProductResponse createProduct(NewProductRequest newProductRequest){
    Product product = Product.builder()
        .name(newProductRequest.getName())
        .description(newProductRequest.getDescription())
        .price(newProductRequest.getPrice())
        .imageUrl(newProductRequest.getImageUrl())
        .build();

    var savedProduct = productRepository.save(product);
    log.info("Saved product: {} ", product.getId());
    return NewProductResponse
        .builder()
        .id(savedProduct.getId())
        .name(savedProduct.getName())
        .description(savedProduct.getDescription())
        .build();
  }

  public List<NewProductResponse> getAllProducts() {
    var products = productRepository.findAll();

    return products
        .stream()
        .map(product -> mapToProductesponse(product))
        .collect(Collectors.toList());
  }

  private static NewProductResponse mapToProductesponse(Product product) {
    return NewProductResponse
        .builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .build();
  }
}
