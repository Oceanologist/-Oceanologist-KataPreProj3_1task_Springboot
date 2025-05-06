package com.kata_academy.pre_proj.springbot.controller.service;


import com.kata_academy.pre_proj.springbot.controller.dao.UserDAO;
import com.kata_academy.pre_proj.springbot.controller.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;


    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public void add(User user) {
        userDAO.add(user);
    }


    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }


    @Override
    public User update(User user) {
        return userDAO.update(user);

    }

    @Transactional(readOnly = true)
    @Override
    public User findById(int id) {
        return userDAO.findUserById(id);

    }

    @Transactional(readOnly = true)
    @Override
    public List<User> viewAllUsers() {
        return userDAO.viewAllUsers();
    }


}