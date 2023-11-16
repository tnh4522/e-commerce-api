package com.example.ecommerceapi.Repository;

import com.example.ecommerceapi.Entity.OrderDetailEntity;
import com.example.ecommerceapi.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
