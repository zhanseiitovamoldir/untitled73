package com.company.Packet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipePage extends JPanel {
    private JButton receptJ, addJ, saveJ, topJ;
    private BossFrame frame=null;

    public RecipePage (BossFrame frame) {
        this.frame = frame;

        setSize(900, 700);
        setLayout(null);

        receptJ = new JButton("РЕЦЕПТЫ");
        receptJ.setBounds(250, 200, 400, 60);
        Font f13 = new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 45);
        receptJ.setForeground(new Color(255, 99, 71));
        receptJ.setFont(f13);
        receptJ.setBackground(Color.white);
        receptJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.recipePage.setVisible(false);
                frame.recipeContainer.setVisible(true);
            }
        });

        addJ = new JButton("ДОБАВЛЯТЬ");
        addJ.setBounds(250, 280, 400, 60);
        Font f14 = new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 45);
        addJ.setForeground(new Color(255, 99, 71));
        addJ.setFont(f14);
        addJ.setBackground(Color.white);
        addJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.recipePage.setVisible(false);
                frame.addContainer.setVisible(true);
            }
        });

        saveJ=new JButton("МОИ ЗАМЕТКИ");
        saveJ.setBounds(250,360,400,60);
        Font f15 = new Font(Font.DIALOG_INPUT, Font.HANGING_BASELINE, 45);
        saveJ.setForeground(new Color(255, 99, 71));
        saveJ.setFont(f15);
        saveJ.setBackground(Color.white);
        saveJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.recipePage.setVisible(false);
               frame.saveContainer.setVisible(true);
               frame.saveContainer.updateTable();
            }
        });

        add(addJ);
        add(receptJ);
        add(saveJ);
    }
}

