package com.example.ecommerceapi.Service;

import com.example.ecommerceapi.Entity.UsersEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UsersEntity> findUserById(long id);
    List<UsersEntity> findAllUsers();
    UsersEntity saveUser(UsersEntity user);
    UsersEntity updateUser(UsersEntity user);
    void deleteUserById(long id);
    Optional<UsersEntity> findUserByEmailAndPassword(String email, String password);

    Optional<UsersEntity> findUserByEmail(String email);
}
