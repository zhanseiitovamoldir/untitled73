package com.company.Packet;

import com.company.Packet.Components.MyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuContainer extends JPanel{
    private MyButton loginB, registrationB;
    private BossFrame frame = null;

    public MenuContainer(BossFrame frame){
        this.frame=frame;

        setSize(900,700);
        setLayout(null);

        loginB = new MyButton("ЛОГИН",70, 500, 250, 30);
        add(loginB);

        registrationB = new MyButton("РЕГИСТРАЦИЯ",70, 550, 250, 30);
        add(registrationB);

        File f = new File("hello.jpg");
        JLabel imgLabel = new JLabel(new ImageIcon(f.getName()));
        imgLabel.setBounds(0, 0, 900, 700);
        add(imgLabel);



        loginB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.menuContainer.setVisible(false);
                frame.loginContainer.setVisible(true);
            }
        });

        registrationB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.menuContainer.setVisible(false);
                frame.registrationContainer.setVisible(true);
            }
        });


    }

    private class LoginContainer {
    }
}



