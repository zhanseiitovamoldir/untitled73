package com.company.Packet;

import com.company.Packet.Components.MyButton;
import com.company.Packet.Components.MyLabel;
import com.company.Packet.Components.MyPasswordField;
import com.company.Packet.Components.MyTextField;
import com.company.addComponents.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginContainer extends JPanel {
    private MyButton backButton, nextButton;
    private MyLabel loginl, passwordl;
    private MyTextField logint;
    private MyPasswordField passwordt;
    private BossFrame frame = null;


    public LoginContainer(BossFrame frame){
        this.frame=frame;

        setSize(900,700);
        setLayout(null);

//        File f = new File("kartinka.jpg");
//        JLabel Label = new JLabel(new ImageIcon(f.getName()));
//        Label.setBounds(0, 0, 900, 700);
//        add(Label);

        loginl = new MyLabel("Логин",30,150,150,50);
        passwordl = new MyLabel("Пароль",30,230,150,50);

        logint = new MyTextField("Войти",100,170,250,50);
        passwordt = new MyPasswordField("",100,240,250,50);

        backButton = new MyButton("Назад",200,5,500,30);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.loginContainer.setVisible(false);
                frame.menuContainer.setVisible(true);
            }
        });

        nextButton = new MyButton("Войти",200,620,500,30);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (logint.getText().isEmpty() || passwordt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Fill all fields");
                } else {
                    User u = new User();
                    u.setLogin(logint.getText());
                    u.setPassword(passwordt.getText());

                    User authUser = frame.clientSocket.toLogin(u);
                    if (authUser != null) {
                        JOptionPane.showMessageDialog(frame, "Добро пожаловать");
                        logint.setText("");
                        passwordt.setText("");
                        frame.loginContainer.setVisible(false);
                        frame.recipePage.setVisible(true);
                        frame.currentUser = authUser;
                    } else
                        JOptionPane.showMessageDialog(frame, "Неверный логин или пароль");
                }
            }

        });


        add(loginl);
        add(logint);
        add(passwordl);
        add(passwordt);
        add(backButton);
        add(nextButton);


    }
}


