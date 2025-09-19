package com.backend.ecommerce_new.controller;

import com.backend.ecommerce_new.entity.Order;
import com.backend.ecommerce_new.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order>findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<?>findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @PostMapping()
    public ResponseEntity<?>addOrder(@Valid @RequestBody Order order) {
        return ResponseEntity.ok(orderService.insert(order));
    }

    @PutMapping()
    public ResponseEntity<?>updateOrder(@Valid @RequestBody Order order) {
        return ResponseEntity.ok(orderService.update(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteOrder(@PathVariable Long id) {
        orderService.DeleteById(id);
        return ResponseEntity.ok(null);
    }



}
