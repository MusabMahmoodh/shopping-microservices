package com.musab.orderservice.service;

import com.musab.orderservice.dto.NewOrderRequest;
import com.musab.orderservice.dto.OrderLineItemsDto;
import com.musab.orderservice.model.Order;
import com.musab.orderservice.model.OrderLineItem;
import com.musab.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

  private final OrderRepository orderRepository;

  public void createOrder(NewOrderRequest newOrderRequest){
    Order order = new Order();

    order.setOrderNumber(UUID.randomUUID().toString());

    List<OrderLineItem> orderLineItemList = newOrderRequest
        .getOrderLineItemsDtoList()
        .stream()
        .map(
            orderLineItemsDto -> {
              OrderLineItem orderLineItems = new OrderLineItem();
              orderLineItems.setProductCode(orderLineItemsDto.getSkuCode());
              orderLineItems.setPrice(orderLineItemsDto.getPrice());
              orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
              return orderLineItems;
            }
        )
        .toList();
    order.setOrderLineItems(orderLineItemList);
    orderRepository.save(order);
  }
}
