package com.example.ecommerceapi.Service.implement;

import com.example.ecommerceapi.Entity.UsersEntity;
import com.example.ecommerceapi.Repository.UserRepository;
import com.example.ecommerceapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<UsersEntity> findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UsersEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UsersEntity saveUser(UsersEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UsersEntity updateUser(UsersEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UsersEntity> findUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Optional<UsersEntity> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
