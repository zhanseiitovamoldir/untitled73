package com.company.Packet.Components;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MyTextArea extends JTextArea {
    public MyTextArea(String text,int x, int y, int a, int b){
        setForeground(new Color(1,45,43));
        setBounds(x,y,a,b);
        setBackground(Color.white);
        setFont(new Font("Arial", Font.ITALIC, 15));
        setBorder(new EtchedBorder(Color.GRAY, Color.GRAY));
        setWrapStyleWord(true);
        setLineWrap(true);
        setOpaque(false);
        setEditable(false);
        setFocusable(false);
    }
}

