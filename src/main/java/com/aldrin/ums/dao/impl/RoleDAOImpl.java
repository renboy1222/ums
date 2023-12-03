/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ums.dao.impl;


import com.aldrin.ums.dao.RoleDAO;
import com.aldrin.ums.entity.Role;
import com.aldrin.ums.util.ComboBoxList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
public class RoleDAOImpl implements RoleDAO {

    @Override
    public void addRole(Role role, EntityManager em) {
        em.getTransaction().begin();
        em.persist(role);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateRole(Role role, EntityManager em) {
        Role r = em.find(Role.class, role.getId());
        em.getTransaction().begin();
        r.setRole(role.getRole());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteRole(Role role, EntityManager em) {
        Role r = em.find(Role.class, role.getId());
        em.getTransaction().begin();
        em.remove(r);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Role> seletRole(EntityManager em) {
        List<Role> role = em.createQuery("SELECT r FROM Role r", Role.class).getResultList();
        return role;
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public void comboBoxRole(EntityManager em) {
        this.setList(new ArrayList<ComboBoxList>());
        List<Role> roleList = em.createQuery("SELECT r FROM Role r ORDER BY r.role ASC", Role.class).getResultList();
        for (Role r : roleList) {
            this.getList().add(new ComboBoxList(r.getId(), r.getRole()));
        }
    }

}
