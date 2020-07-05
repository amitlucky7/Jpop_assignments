package com.epam.userservice.controller;

import com.epam.userservice.model.User;
import com.epam.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/userService")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/Users")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> userList = userService.getAllUsers();
        if(userList.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userList,HttpStatus.OK);

    }

    @PostMapping("/Users")
    public ResponseEntity<User> saveUser(@RequestBody User User){
        try{
            User user =  userService.saveUser(User);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }
        catch(Exception ex){
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/Users/{UserId}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("UserId")int UserId){
        Optional<User> userData =  userService.getUserById(UserId);

        if(userData.isPresent()){
            return new ResponseEntity<>(userData,HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("Users/{userId}")
    public ResponseEntity<User> updateUserDetails(@PathVariable("userId") Integer userId,@RequestBody User user){
        Optional<User> userData = userService.getUserById(userId);
        if(userData.isPresent()){
            User oldUserData = userData.get();
            oldUserData.setName(user.getName());
            oldUserData.setEmail(user.getEmail());
            oldUserData.setUserName(user.getUserName());
            return new ResponseEntity<>(userService.saveUser(oldUserData),HttpStatus.CREATED);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("Users/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable("id") int id){
        try{
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

}
