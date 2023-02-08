package com.example.UserManagementProject.controller;

import com.example.UserManagementProject.model.Model;
import com.example.UserManagementProject.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service=service;
    }


    @PostMapping("/add-user")
    public void addTodo(@RequestBody Model users) {
        Service.addUser(users);
    }


    @GetMapping("/find-user/userId/{userId}")

    public Model findUserById(@PathVariable int userId) {
        return Service.findByUserId(userId);
    }


    @GetMapping("find-all")
    public List<Model> findAllUsers() { // controller is talking to the service layer
        return Service.findAll();
    }


    @PutMapping("update-user/userId/{userId}")
    public void updateUser(@PathVariable int userId,@RequestBody Model user) {
        Service.updateUser(userId,user);
    }


    @DeleteMapping("delete-user/userId/{userId}")
    public void deleteUser(@PathVariable int userId) {
        Service.deleteUser(userId);
    }
}
