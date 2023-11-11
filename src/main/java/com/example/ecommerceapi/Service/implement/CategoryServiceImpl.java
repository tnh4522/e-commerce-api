package com.example.ecommerceapi.Service.implement;

import com.example.ecommerceapi.Entity.CategoryEntity;
import com.example.ecommerceapi.Repository.CategoryRepository;
import com.example.ecommerceapi.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }
}
