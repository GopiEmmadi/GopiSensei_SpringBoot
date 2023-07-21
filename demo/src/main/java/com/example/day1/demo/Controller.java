package com.example.day1.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {
    UserService userService=new UserService();

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") int id){
        return userService.getUserById(id);
    }
    @GetMapping("/users")
    public ArrayList<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/")
    public String greeting(){
        return "jdbc";
    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") int id,@RequestBody User user){
        return userService.updateUser(id,user);
    }
}
