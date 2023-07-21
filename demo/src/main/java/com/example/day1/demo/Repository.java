package com.example.day1.demo;

import java.util.ArrayList;

public interface Repository {
    ArrayList<User> getUsers();
    User getUserById(int userId);
    User addUser(User user);

    User updateUser(int id,User user);
    void deleteUser(int id);
}
