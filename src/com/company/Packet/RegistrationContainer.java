package com.company.Packet;

import com.company.Packet.Components.MyButton;
import com.company.Packet.Components.MyLabel;
import com.company.Packet.Components.MyPasswordField;
import com.company.Packet.Components.MyTextField;
import com.company.addComponents.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationContainer extends JPanel{
    private MyButton backButton, nextButton;
    private MyLabel namel,surnamel, passwordL,loginL;
    private MyTextField namet,surnamet,loginT;
    private MyPasswordField ptf;
    private BossFrame frame = null;


    public RegistrationContainer(BossFrame frame){
        this.frame=frame;

        setSize(900,700);
        setLayout(null);

//        File f = new File("kartinka.jpg");
//        JLabel Label = new JLabel(new ImageIcon(f.getName()));
//        Label.setBounds(0, 0, 900, 700);
//        add(Label);

        namel = new MyLabel("ИМЯ: ",400, 250, 100, 30);
        namel.setBackground(Color.white);
        surnamel = new MyLabel("ФАМИЛИЯ: ",400, 300, 100, 30);
        Font f5 = new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 25);
        loginL=new MyLabel("ЛОГИН: ",400,350,100,30);
        passwordL=new MyLabel("ПАРОЛЬ: ",400,400,100,30);

        namet = new MyTextField("",550, 250, 100, 30);
        surnamet = new MyTextField("",550, 300, 100, 30);
        loginT=new MyTextField("",550,350,100,30);
        ptf = new MyPasswordField("",550,400,100,30);
        add(ptf);




        backButton = new MyButton("Back",350,480,150,30);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.registrationContainer.setVisible(false);
                frame.menuContainer.setVisible(true);
            }
        });

        nextButton = new MyButton("NEXT",550,480,150,30);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ptf.getText().isEmpty() || namet.getText().isEmpty() || surnamet.getText().isEmpty() || loginT.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Fill all fields");
                } else {
                    User u = new User();
                    u.setLogin(loginT.getText());
                    u.setName(namet.getText());
                    u.setPassword(ptf.getText());
                    u.setSurname(surnamet.getText());

                    boolean registered = frame.clientSocket.toRegister(u);
                    if (registered == true) {
                        JOptionPane.showMessageDialog(frame, "You are registered");
                        namet.setText("");
                        surnamet.setText("");
                        ptf.setText("");
                        loginT.setText("");

                        frame.registrationContainer.setVisible(false);
                        frame.recipePage.setVisible(true);
                    }
                }
            }

        });

        add(namel);
        add(surnamel);
        add(namet);
        add(surnamet);
        add(passwordL);
        add(loginL);
        add(loginT);
        add(backButton);
        add(nextButton);


    }
}
