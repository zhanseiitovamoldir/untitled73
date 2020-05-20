package com.company.Packet;

import com.company.addComponents.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class addContainer extends JPanel {
    private JLabel n,i,c,type;
    private JTextField name;
    private JTextArea ing,cook;
    private String foods[] = {"","ТОРТ", "ВЫПЕЧКА", "САЛАТ"};
    private JComboBox  FoodBox;
    private JButton backButton,add;
    private BossFrame frame = null;
    private Object columns[] = {"ID", "NAME", "ingredients", "cook", "type"};
    private ArrayList<Food> food = null;


    public addContainer(BossFrame frame){
        this.frame=frame;

        setSize(900,700);
        setLayout(null);

        n=new JLabel("НАЗВАНИЕ ВАШЕЙ БЛЮДЫ: ");
        n.setBounds(150,80,250,30);
        Font f16 = new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 16);
        n.setForeground(new Color(255, 99, 71));
        n.setFont(f16);
        n.setBackground(Color.white);
        i=new JLabel("ИНГРЕДИЕНТЫ:");
        i.setBounds(150,130,250,30);
        Font f17 = new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 16);
        i.setForeground(new Color(255, 99, 71));
        i.setFont(f17);
        i.setBackground(Color.white);
        i.setBounds(150,130,200,200);
        c=new JLabel("ПРИГОТОВЛЕНИЕ: ");
        c.setBounds(150,350,200,30);
        Font f18 = new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 20);
        c.setForeground(new Color(255, 99, 71));
        c.setFont(f18);
        c.setBackground(Color.white);
        c.setBounds(150,350,200,30);
        type=new JLabel("ВИД:");
        type.setBounds(150,570,200,30);
        Font f19 = new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 20);
        type.setForeground(new Color(255, 99, 71));
        type.setFont(f19);
        type.setBackground(Color.white);
//        type.setBounds(150,570,200,30);

        name=new JTextField();
        name.setBounds(400,80,200,30);
        ing=new JTextArea();
        ing.setBounds(400,130,300,200);
        cook=new JTextArea();
        cook.setBounds(400,350,300,200);
        FoodBox = new JComboBox(foods);
        FoodBox.setBounds(400, 570, 200, 30);

        backButton = new JButton("Back");
        backButton.setLocation(300,630);
        backButton.setSize(80,30);
        Font f20 = new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 10);
        backButton.setForeground(new Color(255, 99, 71));
        backButton.setFont(f20);
        backButton.setBackground(Color.white);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.addContainer.setVisible(false);
                frame.recipePage.setVisible(true);
            }
        });

        add = new JButton("Add");
        add.setLocation(400,630);
        add.setSize(80,30);
        Font f21 = new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 10);
        add.setForeground(new Color(255, 99, 71));
        add.setFont(f21);
        add.setBackground(Color.white);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Food food = new Food (null,name.getText(),ing.getText(), cook.getText(),FoodBox.getSelectedItem().toString());
                frame.clientSocket.addFood(food);
                JOptionPane.showMessageDialog(frame, "YOUR FOOD IS ADDED");
                name.setText("");
                ing.setText("");
                cook.setText("");
                FoodBox.setSelectedIndex(0);

////                updateTable();
            }
        });


        add(n);
        add(i);
        add(c);
        add(type);
        add(name);
        add(ing);

        add(cook);
        add(FoodBox);
        add(backButton);
        add(add);

//
//
//
    }
}

