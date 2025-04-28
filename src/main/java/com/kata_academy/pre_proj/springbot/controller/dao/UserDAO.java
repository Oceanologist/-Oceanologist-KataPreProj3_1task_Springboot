package com.kata_academy.pre_proj.springbot.controller.dao;



import com.kata_academy.pre_proj.springbot.controller.model.User;

import java.util.List;

public interface UserDAO {
    void add(User user);

    void delete(int id);

    void update(User user,int id);

    List<User> viewAllUsers();

    User findUserById(int id);


}