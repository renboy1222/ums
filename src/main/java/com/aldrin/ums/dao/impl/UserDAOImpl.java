/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ums.dao.impl;

import com.aldrin.ums.dao.UserDAO;
import com.aldrin.ums.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author ALDRIN B. C.
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void addUser(User user, EntityManager em) {
        em.getTransaction().begin();;
        em.persist(user);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void updateUser(User user, EntityManager em) {
        User u = em.find(User.class, user.getId());
        em.getTransaction().begin();;
        u.setFirstname(user.getFirstname());
        u.setSurname(user.getSurname());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteUser(User user, EntityManager em) {
        User u = em.find(User.class, user.getId());
        em.getTransaction().begin();;
        em.remove(u);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<User> selectUser(EntityManager em) {
        List<User> user = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        return user;
    }

    @Override
    public User loginUser(User user, EntityManager em) {
        User userInfo = null;
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username =:username and "
                + " u.password =:password", User.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        try {
            userInfo = query.getSingleResult();
            if (!userInfo.getUsername().equals(user.getUsername())) {
                userInfo = null;
            } else if (!userInfo.getPassword().equals(user.getPassword())) {
                userInfo = null;
            }
        } catch (Exception e) {
            System.out.println("No user found!");
        }

        return userInfo;
    }

    @Override
    public void changePassword(User user, EntityManager em) {
        User u = em.find(User.class, user.getId());
        em.getTransaction().begin();
        u.setPassword(user.getPassword());
        em.getTransaction().commit();
        em.close();
    }

}
