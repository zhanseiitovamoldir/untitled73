package com.company.Packet.Components;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    public MyButton(String text,int x, int y,int a,int b){
        setText(text);
        setBounds(x,y,a,b);
        setBackground(new Color(0,255,247));
        setForeground(new Color(3,67,20));
    }
}
