package com.example.ecommerceapi.Service.implement;

import com.example.ecommerceapi.Entity.OrderDetailEntity;
import com.example.ecommerceapi.Entity.OrderEntity;
import com.example.ecommerceapi.Repository.OrderDetailRepository;
import com.example.ecommerceapi.Repository.OrderRepository;
import com.example.ecommerceapi.Service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public OrderEntity saveOrder(OrderEntity orderEntity) {
        int orderID = orderRepository.findAll().size() + 1;
        for (OrderDetailEntity orderDetailEntity : orderEntity.getOrderDetails()) {
            orderDetailEntity.setOrderId((long) orderID);
            orderDetailEntity.setProductId(orderDetailEntity.getProductId());
            orderDetailEntity.setQuantity(orderDetailEntity.getQuantity());
            orderDetailRepository.save(orderDetailEntity);
        }
        return orderRepository.save(orderEntity);
    }

    @Override
    public Iterable<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<OrderEntity> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

}
