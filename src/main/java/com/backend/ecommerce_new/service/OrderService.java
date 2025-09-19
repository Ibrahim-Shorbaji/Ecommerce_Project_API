package com.backend.ecommerce_new.service;

import com.backend.ecommerce_new.entity.Order;
import com.backend.ecommerce_new.entity.OrderItem;
import com.backend.ecommerce_new.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Order findById(Long id) {
        return orderRepo.findById(id).orElseThrow();
    }

    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    public Order insert(Order order) {
        if(order.getId()!=null){
            throw new RuntimeException();
        }
        order.setOrderDate(LocalDateTime.now());

        double total = 0.0;
        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                item.setTotalAmount();
                total += item.getTotalAmount();
                item.setOrder(order);
            }
        }
        return orderRepo.save(order);
    }

    public Order update(Order order) {
        Order entity = orderRepo.findById(order.getId()).orElseThrow();
        entity.setStatus(order.getStatus());

        double total = 0.0;
        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                item.setTotalAmount();
                total += item.getTotalAmount();
                item.setOrder(entity);
            }
            entity.setOrderItems(order.getOrderItems());
        }

        entity.setTotalAmount(total);
        return orderRepo.save(entity);
    }

    public void DeleteById(Long id) {
        orderRepo.deleteById(id);
    }
}
