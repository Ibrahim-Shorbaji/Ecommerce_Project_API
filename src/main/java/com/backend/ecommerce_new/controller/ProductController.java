package com.backend.ecommerce_new.controller;

import com.backend.ecommerce_new.entity.Product;
import com.backend.ecommerce_new.service.ProductService;
import com.backend.ecommerce_new.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;



    @GetMapping("/{id}")
    public ResponseEntity<Product> findByID(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<?>findByName(@PathVariable String name){
        return ResponseEntity.ok(productService.findByName(name));
    }

    @PostMapping()
    public ResponseEntity<?> addProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.insert(product));
    }

    @PutMapping()
    public ResponseEntity<?> updateProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteByID(id);
        return  ResponseEntity.ok(null);

    }


}
