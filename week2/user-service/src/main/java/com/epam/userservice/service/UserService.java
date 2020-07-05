package com.epam.userservice.service;

import com.epam.userservice.dao.UserRepository;
import com.epam.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public List<User> getAllUsers(){
        List<User> UsersList = new ArrayList<>();
        UserRepository.findAll().forEach(Users -> UsersList.add(Users));
        return UsersList;
    }

    public User saveUser(User Users){
        return UserRepository.save(Users);
    }

    public void deleteUser(int id){
        UserRepository.deleteById(id);
    }

    public Optional<User> getUserById(int id){
        return UserRepository.findById(id);

    }
}
