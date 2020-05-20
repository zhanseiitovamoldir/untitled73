package com.company.Packet.Components;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MyTextField extends JTextField {

    public MyTextField(String text,int x, int y,int a,int b){
        setForeground(new Color(3,67,20));
        setBackground(Color.white);
        setBounds(x,y,a,b);
        setFont(new Font("Arial", Font.ITALIC, 15));
        setBorder(new EtchedBorder(Color.GRAY, Color.GRAY));
    }
}

