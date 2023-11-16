package com.example.ecommerceapi.Service;

import com.example.ecommerceapi.Entity.OrderDetailEntity;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailEntity> getOrderDetailsByOrderId(Long id);
}
