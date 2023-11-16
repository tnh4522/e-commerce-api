package com.example.ecommerceapi.Service;

import com.example.ecommerceapi.Entity.OrderDetailEntity;
import com.example.ecommerceapi.Entity.OrderEntity;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface OrderService {
    OrderEntity saveOrder(OrderEntity orderEntity);

    Iterable<OrderEntity> getAllOrders();

    Optional<OrderEntity> findOrderById(Long id);

}
