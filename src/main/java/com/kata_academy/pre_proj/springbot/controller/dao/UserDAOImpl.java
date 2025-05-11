package com.kata_academy.pre_proj.springbot.controller.dao;

import com.kata_academy.pre_proj.springbot.controller.model.User;
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
    public void update(User user) {
        manager.merge(user);
    }

    @Override
    public List<User> viewAllUsers() {
        String jpql = "FROM User";
        TypedQuery<User> query = manager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public User findUserById(int id) {
        return manager.find(User.class, id);

    }

    @Override
    public void delete(int id) {
        manager.createQuery("delete  from User u where u.id =:id ")
                .setParameter("id", id)
                .executeUpdate();
    }
}