/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.ums.dao;


import com.aldrin.ums.entity.Role;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ALDRIN B. C.
 */
public interface RoleDAO {
//    add Role
    public void addRole(Role role, EntityManager em);
//    update Role
    public void updateRole(Role role, EntityManager em);
//    delete Role
    public void deleteRole(Role role, EntityManager em);
//    list of Role
    public List<Role> seletRole(EntityManager em);
    
    public void comboBoxRole(EntityManager em);
}
