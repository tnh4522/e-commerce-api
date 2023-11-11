package com.example.ecommerceapi.Service.implement;

import com.example.ecommerceapi.Entity.BrandEntity;
import com.example.ecommerceapi.Repository.BrandRepository;
import com.example.ecommerceapi.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public List<BrandEntity> getAllBrands() {
        return brandRepository.findAll();
    }
}
