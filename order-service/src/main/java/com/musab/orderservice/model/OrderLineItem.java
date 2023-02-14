package com.musab.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_line_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String productCode;
  private Double price;
  private Integer quantity;
}
