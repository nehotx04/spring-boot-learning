package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    
    @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping()
    public UserModel createUser(@RequestBody UserModel user){
        return this.userService.createUser(user);
    }

    @GetMapping( path= "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return userService.getById(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> getUserByPriority(@RequestParam("priority") Integer priority){
        return this.userService.getByPriority(priority);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id")Long id){
        boolean ok = this.userService.deleteUser(id);
        if(ok){
            return "User with id " + id + " deleted successfully";
        }else{
            return "Couldnt delete the user with id:" + id;
        }
    }

}
