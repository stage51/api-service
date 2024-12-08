package com.example.api_service.repos;

import com.example.api_service.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserRepository{
    private List<User> users = new ArrayList<>();
    public User save(User user){
        this.users.add(user);
        return user;
    }
    public void saveAll(List<User> users){
        this.users.addAll(users);
    }
    public List<User> findAll(){
        return users;
    }
}

