package com.backend.ecommerce_new.service;

import com.backend.ecommerce_new.repository.UserRepo;
import com.backend.ecommerce_new.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public User insert (User user) {
        if(user.getId()!=null){
            throw new RuntimeException();
        }
        return userRepo.save(user);
    }

    public List<User>insertAll(List<User> users) {
        return userRepo.saveAll(users);
    }

    public User update (User user) {
        User entity=userRepo.findById(user.getId()).orElse(null);
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        return userRepo.save(entity);
    }

    public void DeleteById(Long id) {
        userRepo.deleteById(id);
    }
}
