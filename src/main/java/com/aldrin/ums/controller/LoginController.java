/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ums.controller;

import com.aldrin.ums.config.HibernateConfig;
import com.aldrin.ums.dao.impl.UserDAOImpl;
import com.aldrin.ums.entity.Role;
import com.aldrin.ums.entity.User;
import com.aldrin.ums.gui.JFrameLogin;
import com.aldrin.ums.gui.JFrameMain;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author ALDRIN B. C.
 */
public class LoginController {

    private JFrameLogin jFrameLogin = new JFrameLogin();
    private JFrameMain jFrameMain = new JFrameMain();
    private UserDAOImpl userDAOImpl = new UserDAOImpl();
    private HibernateConfig hibernateConfig = new HibernateConfig();

    public LoginController(JFrameLogin jFrameLogin) {
        this.jFrameLogin = jFrameLogin;
        this.jFrameLogin.setVisible(true);
        this.jFrameLogin.addLoingListener(new LoginListener());
        this.jFrameLogin.addLoginKeyListener(new LoginKeyListener());
    }

    class LoginKeyListener extends KeyAdapter {

        public void keyPressed(KeyEvent evt) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                userAccessAccount();
            }
        }
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            userAccessAccount();
        }
    }

    private void userAccessAccount() {
        User user = new User();
        user.setUsername(jFrameLogin.getjTextFieldUsername().getText());
        user.setPassword(jFrameLogin.getjPasswordFieldPassword().getText());
        User u = null;
        try {
            u = userDAOImpl.loginUser(user, hibernateConfig.getEntityManager());
            if (u != null) {
                jFrameLogin.dispose();
                loginRole(u.getRole());
                jFrameMain.getjMenuUser().setText(u.getSurname() + ", " + u.getFirstname());
                jFrameMain.setUser(u);
                jFrameMain.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println("User not found!!");
        }
        if (u == null) {
            jFrameLogin.getjLabelErrorMessage().setText("Please check your username and password and try again.");
            jFrameLogin.getjTextFieldUsername().putClientProperty("JComponent.outline", "error");
            jFrameLogin.getjPasswordFieldPassword().putClientProperty("JComponent.outline", "error");

        }

    }

    private void loginRole(Role r) {
        String role = r.getRole();
        CardLayout cardLayOut = (CardLayout) jFrameMain.getjPanelContainer().getLayout();
        switch (role) {
            case "ADMIN":
                cardLayOut.show(jFrameMain.getjPanelContainer(), "admin");
                jFrameMain.getjMenuSetup().setVisible(true);
                break;
            case "USER":
                cardLayOut.show(jFrameMain.getjPanelContainer(), "user");
                jFrameMain.getjMenuSetup().setVisible(false);
                break;
            default:
                throw new AssertionError();
        }
    }

}
