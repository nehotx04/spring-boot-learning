package com.api.taskList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.taskList.models.User;
import com.api.taskList.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    //GET
    @GetMapping
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    //POST
    @PostMapping
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }

    //PUT
    @PostMapping("edit/{id}")
    public User update(@RequestBody User user , @PathVariable Long id){
        user.setId(id);
        return userService.updatUser(user);
    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteUserById(id);
    }

}
