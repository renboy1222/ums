/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.aldrin.ums;

import com.aldrin.ums.controller.LoginController;
import com.aldrin.ums.gui.JFrameLogin;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author ALDRIN B. C.
 */
public class Ums {

    public static void main(String[] args) {
        FlatLightLaf.setup();

        UIManager.put("Button.arc", 12);//JButton
        UIManager.put("ProgressBar.arc", 10);//JProgressBar
        UIManager.put("TextComponent.arc", 10);//JTextField,JPasswordField,JFormattedTextField
        UIManager.put("CheckBox", 0);//JCheckBox
        UIManager.put("Component.arc", 8);//JComboBox,JSpinner

        UIManager.put("Component.innerFocusWidth", 2);//JComboBox, JTextField,JPasswordField,JFormattedTextField,JSpinner
        UIManager.put("Button.innerFocusWidth", 2);//JButton

        UIManager.put("JRootPane.titleBarBackground", new Color(70, 130, 180));
        System.setProperty("flatlaf.menuBarEmbedded", "false");
        JFrameLogin login = new JFrameLogin();
        new LoginController(login);
    }
}
