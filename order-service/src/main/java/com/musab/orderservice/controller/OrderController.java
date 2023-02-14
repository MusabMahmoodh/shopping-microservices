package com.musab.orderservice.controller;


import com.musab.orderservice.dto.NewOrderRequest;
import com.musab.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createOrder(
      @RequestBody NewOrderRequest newOrderRequest
  ){
    orderService.createOrder(newOrderRequest);
  }
}
