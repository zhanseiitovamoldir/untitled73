package com.company.Packet;

import com.company.Packet.Components.MyLabel;
import com.company.Packet.Components.MyTable;
import com.company.Packet.Components.MyTextArea;
import com.company.addComponents.Food;
import com.company.addComponents.MyBasket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class RecipesContainer extends JPanel {
    private MyTable table;
    private JScrollPane pane;
    private Object columns[] = {"NAME","TYPE"};
    private JButton nazadB;
    private JComboBox typeCombo;
    private String types[] = {"", "ТОРТЫ", "ВЫПЕЧКА", "САЛАТ"};
    private BossFrame frame = null;
    private ArrayList<Food> foods = null;
    private JButton takeButton;
    private JTextField takeField;
    private JButton save;
    private JLabel nl;
    private JTextField nameJ,ingJ,cookJ;
    private MyTextArea ingl,cookl;


    public RecipesContainer(BossFrame frame) {
        this.frame = frame;
        setSize(900, 700);
        setLayout(null);


        nazadB = new JButton("Назад");
        nazadB.setBounds(380, 580, 100, 30);
        add(nazadB);
        nazadB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.recipeContainer.setVisible(false);
                frame.recipePage.setVisible(true);
            }
        });

//        save = new JButton("МОИ ЗАМЕТКИ");
//        save.setBounds(400, 620, 130, 30);
//        add(save);

        table = new MyTable(columns);
        pane = new JScrollPane(table);
        pane.setBounds(0, 0, 200, 500);
        add(pane);
        updateTable(false);

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowind = table.getSelectedRow();

                nl.setText("Имя: " + foods.get(rowind).getName());
                ingl.setText(foods.get(rowind).getIngredients());
                cookl.setText(foods.get(rowind).getCooking());

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        typeCombo = new JComboBox(types);
        typeCombo.setBounds(0, 600, 200, 40);
        add(typeCombo);
        typeCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTable(true);
            }
        });





//        takeField=new JTextField();
//        takeField.setBounds(380,580,150,30);
//        add(takeField);
        takeButton=new JButton("СОХРАНИТЬ");
        takeButton.setBounds(560,580,150,30);
        add(takeButton);
        takeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int rowind = table.getSelectedRow();

                MyBasket mb = new MyBasket(
                        frame.currentUser.getId(),
                        foods.get(rowind).getName(),
                        foods.get(rowind).getIngredients(),
                        foods.get(rowind).getCooking()

                );


                frame.clientSocket.addMyBasket(mb);
                JOptionPane.showMessageDialog(frame, "СОХРАНЕНО");
            }
        });

        nl = new MyLabel("name: ", 360, 30,300,30);
        add(nl);
        ingl = new MyTextArea("ingredients: ", 360, 70,300,250);
        add(ingl);
        cookl = new MyTextArea("cook: ", 360, 330,300,230);
        add(cookl);

    }

    private void updateTable(boolean byCategory) {
        while (table.model.getRowCount() > 0){
            table.model.removeRow(0);
        }
        if(byCategory == true && !((String)typeCombo.getSelectedItem()).equals(""))
            foods = frame.clientSocket.getFoodsByType((String)typeCombo.getSelectedItem());
        else
            foods = frame.clientSocket.getAllFoods();

        for(Food f : foods){
            table.model.addRow(new Object[]{f.getName(),f.getCategory()});
        }
    }
}