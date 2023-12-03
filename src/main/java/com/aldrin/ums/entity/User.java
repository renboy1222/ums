/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ums.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
@ToString
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String surname;
    @Column(unique = true)
    private String username;
    private String password;
    
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
    
    public User(){
        
    }
    
    public User(Long id, String firstname, String surname, String username, String password,Role role){
        this.id =id;
        this.firstname =firstname;
        this.surname =surname;
        this.username =username;
        this.password =password;
        this.role =role;
    }    
    
    
}
