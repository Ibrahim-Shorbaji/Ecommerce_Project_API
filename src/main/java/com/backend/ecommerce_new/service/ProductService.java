package com.backend.ecommerce_new.service;

import com.backend.ecommerce_new.entity.Product;
import com.backend.ecommerce_new.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product findById(Long id)
    {
        return productRepo.findById(id).orElseThrow();
    }

    public List<Product> findAll()
    {
        return productRepo.findAll();
    }

    public Optional<Product> findByName(String name)
    {
        return productRepo.findByName(name);
    }

    public Product insert(Product product)
    {
        if(product.getId()!=null)
        {
            throw new RuntimeException();
        }
        return productRepo.save(product);
    }

    public List<Product> insertAll(List<Product> products)
    {
        return productRepo.saveAll(products);
    }

    public Product update(Product product)
    {
        Product entity = productRepo.findById(product.getId()).orElseThrow();
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setStockQuantity(product.getStockQuantity());
        entity.setDescription(product.getDescription());

        return productRepo.save(entity);
    }
public void deleteByID(Long id)
{
    productRepo.deleteById(id);
}
}
