package com.epam.userservice.controller;

import com.epam.userservice.model.User;
import com.epam.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/v1/api")
public class UserController {

    @Autowired
    UserService UserService;

    @GetMapping("/Users")
    public List<User> getAllUsers(){
        return UserService.getAllUsers();
    }

    @PostMapping("/Users")
    public int saveUser(@RequestBody User User){
        UserService.saveUser(User);
        return User.getUserId();
    }

    @GetMapping("/Users/{UserId}")
    public Optional<User> getUserById(@PathVariable("UserId")int UserId){
        return UserService.getUserById(UserId);
    }

    @PutMapping("Users")
    public void updateUserDetails(User Users){
        UserService.updateUser(Users);
    }

    @DeleteMapping("Users/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        UserService.deleteUser(id);
    }

}
