package com.company.Packet.Components;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MyPasswordField extends JPasswordField {
    public MyPasswordField(String text,int x, int y,int a, int b){
        setForeground(new Color(1,45,43));
        setBackground(Color.white);
        setBounds(x, y,a,b);
        setFont(new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 25));
        setBorder(new EtchedBorder(Color.GRAY, Color.GRAY));
    }
}
