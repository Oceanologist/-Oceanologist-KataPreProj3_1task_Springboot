package com.kata_academy.pre_proj.springbot.controller.service;



import com.kata_academy.pre_proj.springbot.controller.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void delete(int id);

    User update(User user);

    User findById(int id);

    List<User> viewAllUsers();
}