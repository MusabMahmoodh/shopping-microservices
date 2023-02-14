package com.musab.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrderRequest {
  private List<OrderLineItemsDto> orderLineItemsDtoList;
}
