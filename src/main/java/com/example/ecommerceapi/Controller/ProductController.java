package com.example.ecommerceapi.Controller;

import com.example.ecommerceapi.Entity.ProductEntity;
import com.example.ecommerceapi.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://food-mart-e-commerce.onrender.com")
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("list")
    public ResponseEntity<List<ProductEntity>> findAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }
    @GetMapping("detail/{id}")
    public ResponseEntity<ProductEntity> findProductById(@PathVariable Long id) {
        Optional<ProductEntity> productOptional = productService.findProductById(id);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("cart")
    public ResponseEntity<List<ProductEntity>> getProductsInCart(@RequestBody Map<Long, Integer> productQuantities) {
        if (productQuantities != null && !productQuantities.isEmpty()) {
            List<Long> productIds = new ArrayList<>(productQuantities.keySet());
            List<ProductEntity> productsInCart = productService.findProductsByIds(productIds);
            for (ProductEntity product : productsInCart) {
                product.setQuantity(productQuantities.get(product.getId()));
            }
            return ResponseEntity.ok(productsInCart);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<ProductEntity> productOptional = productService.findProductById(id);
        if (productOptional.isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping ("add")
    @Procedure(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity product) {
        System.out.println(product.getCompanyProfile());
        System.out.println(product.getDetail());
        System.out.println(product.getImage());
        return ResponseEntity.ok(productService.saveProduct(product));
    }
    @PostMapping("update/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody ProductEntity product) {
        Optional<ProductEntity> productOptional = productService.findProductById(id);
        System.out.println(id);
        System.out.println(productOptional);
        System.out.println(product);
        if (productOptional.isPresent()) {
            ProductEntity productEntity = productOptional.get();
            productEntity.setName(product.getName());
            productEntity.setPrice(product.getPrice());
            productEntity.setCompanyProfile(product.getCompanyProfile());
            productEntity.setDetail(product.getDetail());
            productEntity.setStatus(product.getStatus());
            productEntity.setSale(product.getSale());
            productEntity.setHighlight(product.getHighlight());
            productEntity.setActive(product.getActive());
            productEntity.setCondition(product.getCondition());
            productEntity.setImage(product.getImage());
            productEntity.setIdBrand(product.getIdBrand());
            productEntity.setIdCategory(product.getIdCategory());
            productEntity.setIdUser(product.getIdUser());
            return ResponseEntity.ok(productService.updateProduct(productEntity));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
