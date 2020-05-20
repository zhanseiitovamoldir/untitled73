package com.company.Packet.Components;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    public MyLabel(String text,int x, int y,int a,int b){
        setText(text);
        setBounds(x,y,a,b);
        setForeground(new Color(3,67,20));
        setFont(new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 15));
    }
}
