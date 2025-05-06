package com.kata_academy.pre_proj.springbot.controller.dao;


import com.kata_academy.pre_proj.springbot.controller.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void add(User user) {
        manager.persist(user);
    }


    @Override
    public User update(User user) {
        User user1 = new User();
        user1.setId(user.getId());
        user1 = manager.merge(user);
        return user1;
    }


    @Override
    public List<User> viewAllUsers() {
        return manager.createQuery("FROM User", User.class).
                getResultList();
    }

    @Override
    public User findUserById(int id) {
        return manager.find(User.class, id);

    }

    @Override
    public void delete(int id) {

        manager.createQuery("delete  from User u where u.id =:id ").setParameter("id", id).
                executeUpdate();
    }
}