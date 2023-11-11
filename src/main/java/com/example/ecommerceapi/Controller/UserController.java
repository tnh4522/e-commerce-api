package com.example.ecommerceapi.Controller;

import com.example.ecommerceapi.Entity.UsersEntity;
import com.example.ecommerceapi.Respon.ResponBody;
import com.example.ecommerceapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://food-mart-e-commerce.onrender.com")
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("{id}")
    public ResponseEntity<UsersEntity> findUserById(@PathVariable Long id) {
        Optional<UsersEntity> userOptional = userService.findUserById(id);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/list")
    public ResponseEntity<Iterable<UsersEntity>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }
    @PostMapping("/login")
    public ResponseEntity<UsersEntity> login(@RequestBody UsersEntity user) {
        Optional<UsersEntity> userOptional = userService.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if(userOptional.isPresent()) {
            UsersEntity userEntity = userOptional.get();
            userEntity.setPassword("");
            return ResponseEntity.ok(userEntity);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<UsersEntity> register(@RequestBody UsersEntity user) {
        Optional<UsersEntity> userOptional = userService.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()) {
            String message = "Email already exists";
            int status = 400;
            ResponBody responBody = new ResponBody(message, status);
            return new ResponseEntity(responBody, HttpStatus.BAD_REQUEST);
        } else {
            return ResponseEntity.ok(userService.saveUser(user));
        }
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<UsersEntity> update(@PathVariable Long id, @RequestBody UsersEntity user) {
        Optional<UsersEntity> userOptional = userService.findUserById(id);
        if (userOptional.isPresent()) {
            UsersEntity userEntity = userOptional.get();
            userEntity.setAddress(user.getAddress());
            userEntity.setName(user.getName());
            userEntity.setPhone(user.getPhone());
            userEntity.setEmail(user.getEmail());
            userEntity.setPassword(user.getPassword() == null ? userEntity.getPassword() : user.getPassword());
            userEntity.setAvatar(user.getAvatar() == null ? userEntity.getAvatar() : user.getAvatar());
            userService.updateUser(userEntity);
            userEntity.setPassword("");
            return ResponseEntity.ok(userEntity);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
