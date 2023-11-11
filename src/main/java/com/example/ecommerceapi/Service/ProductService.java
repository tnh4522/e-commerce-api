package com.example.ecommerceapi.Service;

import com.example.ecommerceapi.Entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductEntity> findProductById(long id);
    List<ProductEntity> findAllProducts();
    List<ProductEntity> findProductsByIds(List<Long> productIds);

    void deleteProduct(Long id);
    ProductEntity saveProduct(ProductEntity product);

    ProductEntity updateProduct(ProductEntity productEntity);
}
