package com.company.Packet;

import com.company.Packet.Components.MyButton;
import com.company.Packet.Components.MyTable;
import com.company.addComponents.MyBasket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class SaveContainer extends JPanel {
    private BossFrame frame = null;

    private ArrayList<MyBasket> myBaskets = null;

    private MyTable table;
    private JScrollPane pane;
    private Object columns[] = {"NAME", "INGREDIENTS", "COOKING"};
    int rowind = 0;

    private MyButton backb, deleteB;

    public SaveContainer(BossFrame frame) {
        this.frame = frame;

        setSize(900, 700);
        setLayout(null);
        setBackground(Color.white);

        table = new MyTable(columns);
        pane = new JScrollPane(table);
        pane.setBounds(100, 0, 600, 500);
        add(pane);
//        updateTable();


        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });

        backb = new MyButton("BACK", 400, 600, 100, 30);
        add(backb);

        backb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.saveContainer.setVisible(false);
                frame.recipePage.setVisible(true);
            }
        });
    }

    public void updateTable() {
        while (table.model.getRowCount() > 0) {
            table.model.removeRow(0);
        }

        myBaskets = frame.clientSocket.getAllMyBaskets((long) frame.currentUser.getId());
        for (MyBasket myBaskets : myBaskets) {
            table.model.addRow(new Object[]{myBaskets.getName(), myBaskets.getIngredients(), myBaskets.getCooking()});
        }
    }
}




