package com.example.ecommerceapi.Controller;

import com.example.ecommerceapi.Entity.OrderDetailEntity;
import com.example.ecommerceapi.Entity.OrderEntity;
import com.example.ecommerceapi.Service.OrderDetailService;
import com.example.ecommerceapi.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://food-mart-e-commerce.onrender.com")
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @PostMapping("add")
    @Procedure(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderEntity> addOrder(@RequestBody OrderEntity order) {
        OrderEntity savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }
    @GetMapping("/list")
    public ResponseEntity<List<OrderEntity>> findAllOrdersWithDetails() {
        Iterable<OrderEntity> orderEntities = orderService.getAllOrders();
        List<OrderEntity> ordersWithDetails = new ArrayList<>();

        for (OrderEntity order : orderEntities) {
            List<OrderDetailEntity> orderDetails = orderDetailService.getOrderDetailsByOrderId(order.getId());
            order.setOrderDetails(orderDetails);
            ordersWithDetails.add(order);
        }

        return ResponseEntity.ok(ordersWithDetails);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<OrderEntity> findOrderById(@PathVariable Long id) {
        Optional<OrderEntity> orderOptional = orderService.findOrderById(id);
        if(orderOptional.isPresent()) {
            OrderEntity orderEntity = orderOptional.get();
            List<OrderDetailEntity> orderDetailEntities = orderDetailService.getOrderDetailsByOrderId(id);
            orderEntity.setOrderDetails(orderDetailEntities);
            return ResponseEntity.ok(orderEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
