package com.example.springboot.springbootsolution.service;

import com.example.springboot.springbootsolution.model.User;


import java.util.List;

public interface UserService {
    void saveUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();

    User getUser(Long id);

    void editUser(User user, Long id);
}
