package com.example.ecommerceapi.Service.implement;

import com.example.ecommerceapi.Entity.ProductEntity;
import com.example.ecommerceapi.Repository.ProductRepository;
import com.example.ecommerceapi.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Optional<ProductEntity> findProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductEntity> findProductsByIds(List<Long> productIds) {
        List<ProductEntity> products = new ArrayList<>();
        for (Long id : productIds) {
            Optional<ProductEntity> productOptional = findProductById(id);
            productOptional.ifPresent(products::add);
        }
        return products;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }
}
