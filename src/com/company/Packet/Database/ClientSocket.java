package com.company.Packet.Database;



import com.company.addComponents.Food;
import com.company.addComponents.General;
import com.company.addComponents.MyBasket;
import com.company.addComponents.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientSocket {
    private Socket socket = null;
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;

    public ClientSocket() {
        try {
            socket = new Socket("localhost", 2020);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            oos.close();
            ois.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean toRegister(User user) {
        String code = "";

        try {
            General general = new General("REGISTRATION", user);
            oos.writeObject(general);

            General answerPacket = (General) ois.readObject();
            code = answerPacket.getCode();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (code.equals("CONNECTED"))
            return true;

        return false;
    }
    public User toLogin(User user) {
        User authUser = null;
        try {
            General general = new General("LOGIN", user);
            oos.writeObject(general);

            General answerPacket = (General) ois.readObject();
            authUser = (User) answerPacket.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return authUser;
    }
    public ArrayList<Food> getAllFoods() {
        ArrayList<Food> foods = null;
        General general = new General("FOODS");//otpravlyaem k serveru list foods
        try {
            oos.writeObject(general);
            General response = (General) ois.readObject();
            foods = (ArrayList<Food>) response.getData();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return foods;
    }
    public void addFood(Food food) {
        General general = new General("ADD_FOOD", food);
        try {
            oos.writeObject(general);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Food> getFoodsByType(String category){
        ArrayList<Food> foods=null;
        General general=new General("LIST_Foods_Type", category);
        try {
            oos.writeObject(general);
            General response=(General)ois.readObject();
            foods=(ArrayList<Food>)response.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foods;
    }

    public void addMyBasket(MyBasket myBasket){
        General general=new General("ADD_MyBasket",myBasket);
        try {
            oos.writeObject(general);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MyBasket> getAllMyBaskets(Long userid){
        ArrayList<MyBasket> myBaskets=null;
        General general =new General("LIST_MyBaskets", userid);
        try {
            oos.writeObject(general);
            General response=(General)ois.readObject();
            myBaskets=(ArrayList<MyBasket>)response.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myBaskets;
    }



}

