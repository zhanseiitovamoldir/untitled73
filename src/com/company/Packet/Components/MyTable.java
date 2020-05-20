package com.company.Packet.Components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyTable extends JTable {
    public DefaultTableModel model;

    public MyTable(Object columns[]){
        model=new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        setModel(model);
        setBackground(Color.lightGray);
        setForeground(Color.black);
        setFont(new Font("Arial", Font.PLAIN, 12));
        setRowHeight(20);
    }
}
