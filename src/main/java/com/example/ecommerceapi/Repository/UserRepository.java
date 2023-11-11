package com.example.ecommerceapi.Repository;

import com.example.ecommerceapi.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {
    Optional<UsersEntity> findByEmailAndPassword(String email, String password);
    Optional<UsersEntity> findByEmail(String email);
}
