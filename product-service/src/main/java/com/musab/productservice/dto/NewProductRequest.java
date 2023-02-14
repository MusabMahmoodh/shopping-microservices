package com.musab.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewProductRequest {
  private String name;
  private String description;
  private Double price;
  private String imageUrl;
}
