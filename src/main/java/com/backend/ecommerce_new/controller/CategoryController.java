package com.backend.ecommerce_new.controller;

import com.backend.ecommerce_new.entity.Category;
import com.backend.ecommerce_new.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category>findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<?>findAll()
    {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<?>findByName(@PathVariable String name)
    {
        return ResponseEntity.ok(categoryService.findByName(name));
    }

    @PostMapping()
    public ResponseEntity<?> addCategory(@Valid @RequestBody Category category)
    {
        return ResponseEntity.ok(categoryService.insert(category));
    }

    @PutMapping()
    public ResponseEntity<?>updateCategory(@Valid @RequestBody Category category)
    {
        return ResponseEntity.ok(categoryService.update(category));
    }

    @DeleteMapping()
    public ResponseEntity<?>DeleteById(@PathVariable Long id)
    {
        categoryService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
