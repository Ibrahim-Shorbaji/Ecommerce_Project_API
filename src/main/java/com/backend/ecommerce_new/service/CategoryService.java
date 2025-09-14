package com.backend.ecommerce_new.service;

import com.backend.ecommerce_new.entity.Category;
import com.backend.ecommerce_new.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category findById(Long id) {
        return categoryRepo.findById(id).orElseThrow();
    }

    public List<Category> findAll()
    {
        return categoryRepo.findAll();
    }

    public Optional<Category> findByName(String name)
    {
        return categoryRepo.findByName(name);
    }

    public Category insert(Category category)
    {
        if(category.getId()!=null)
        {
            throw new RuntimeException();
        }
        return categoryRepo.save(category);
    }

    public Category update(Category category)
    {
        Category entity =categoryRepo.findById(category.getId()).orElseThrow();
        entity.setName(category.getName());

        return categoryRepo.save(entity);
    }

    public void  deleteById(Long id)
    {
       categoryRepo.deleteById(id);
    }

}
