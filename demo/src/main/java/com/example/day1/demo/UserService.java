package com.example.day1.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;

public class UserService implements Repository{
    private HashMap<Integer,User> h=new HashMap<>();
    int id=3;
    public UserService(){
        User u1=new User(1,"sensei",15);
        User u2=new User(2,"edge verve",20);
        h.put(u1.getId(),u1);
        h.put(u2.getId(),u2);
    }

    @Override
    public void deleteUser(int id) {
        User user=h.get(id);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        h.remove(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public User updateUser(int id, User user) {
        User existingUser=h.get(id);

        if (existingUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }

        if ((Object) user.getAge() != null) {
            existingUser.setAge(user.getAge());
        }
        return existingUser;
    }

    @Override
    public ArrayList<User> getUsers() {
        return new ArrayList<>(h.values());
    }

    @Override
    public User getUserById(int userId) {
        User user=h.get(userId);
        if (user == null) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return user;
    }

    @Override
    public User addUser(User user){
        user.setId(id);
        h.put(id,user);
        id++;
        return user;
    }
}
