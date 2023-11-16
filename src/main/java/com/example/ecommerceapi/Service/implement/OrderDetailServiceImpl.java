package com.example.ecommerceapi.Service.implement;

import com.example.ecommerceapi.Entity.OrderDetailEntity;
import com.example.ecommerceapi.Repository.OrderDetailRepository;
import com.example.ecommerceapi.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetailEntity> getOrderDetailsByOrderId(Long id) {
        return orderDetailRepository.findByOrderId(id);
    }
}
