package com.example.ecommerceapi.Repository;

import com.example.ecommerceapi.Entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {
}
