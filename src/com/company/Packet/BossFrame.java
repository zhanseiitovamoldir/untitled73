package com.company.Packet;

import com.company.Packet.Database.ClientSocket;
import com.company.addComponents.User;

import javax.swing.*;

public class BossFrame extends JFrame {

    public MenuContainer menuContainer;
    public  LoginContainer loginContainer;
    public  RegistrationContainer registrationContainer;
    public ClientSocket clientSocket;
    public RecipePage recipePage;
    public RecipesContainer recipeContainer;
    public User currentUser = null;
    public SaveContainer saveContainer;
    public addContainer addContainer;

    public BossFrame(){
        clientSocket = new ClientSocket();

        setSize(900,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setTitle("Кулинарная книга");

        saveContainer=new SaveContainer(this);
        saveContainer.setVisible(false);
        add(saveContainer);

        recipeContainer=new RecipesContainer(this);
        recipeContainer.setVisible(false);
        add(recipeContainer);
//
        addContainer=new addContainer(this);
        addContainer.setVisible(false);
        add(addContainer);
//
        recipePage =new RecipePage(this);
        recipePage.setVisible(false);
        add(recipePage);


        menuContainer = new MenuContainer(this);
        menuContainer.setVisible(true);
        add(menuContainer);

        loginContainer = new LoginContainer(this);
        loginContainer.setVisible(false);
        add(loginContainer);

        registrationContainer = new RegistrationContainer(this);
        registrationContainer.setVisible(false);
        add(registrationContainer);

    }
}

