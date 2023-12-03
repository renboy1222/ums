/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.ums.dao;


import com.aldrin.ums.entity.User;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ALDRIN B. C.
 */
public interface UserDAO {
//    add User
    public void addUser(User user, EntityManager em);
//    update User
    public void updateUser(User user, EntityManager em);
//    delete User
    public void deleteUser(User user, EntityManager em);
//    list of the User
    public List<User> selectUser(EntityManager em);
    
    public User loginUser(User user, EntityManager em);
    
    public void changePassword(User user, EntityManager em);
}
