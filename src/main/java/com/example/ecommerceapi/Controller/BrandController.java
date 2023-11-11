package com.example.ecommerceapi.Controller;

import com.example.ecommerceapi.Entity.BrandEntity;
import com.example.ecommerceapi.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://food-mart-e-commerce.onrender.com")
@RequestMapping("/api/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping
    public ResponseEntity<List<BrandEntity>> findAllBrands() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }
}
