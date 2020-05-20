package com.company.Server;

import com.company.addComponents.Food;
import com.company.addComponents.General;
import com.company.addComponents.MyBasket;
import com.company.addComponents.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            General general = null;

            while((general = (General)ois.readObject()) != null) {
                if (general.getCode().equals("REGISTRATION")) {
                    User user = (User) general.getData();
                    boolean reged = Server.registerUser(user);

                    General general2 = null;

                    if (reged == true)
                        general2 = new General("CONNECTED");
                    else
                        general2 = new General("FAIL");

                    oos.writeObject(general2);

                } else if (general.getCode().equals("LOGIN")) {
                    User user = (User) general.getData();
                    User authUser = Server.loginUser(user);

                    General general2 = new General("ANSWER", authUser);
                    oos.writeObject(general2);
                }

                if (general.getCode().equals("ADD_FOOD")) {
                    Server.addFood((Food) general.getData());
                }

                if(general.getCode().equals("LIST_FOODS")){
                    General general2 = new General("ANSWER_LIST", Server.getAllFoods());
                    oos.writeObject(general2);
                }

                if(general.getCode().equals("LIST_Foods_Type")){
                    General general2 = new General("ANSWER_LIST", Server.getFoodsByType((String)general.getData()));
                    oos.writeObject(general2);
                }

                if (general.getCode().equals("FOODS")) {
                    General packet2 = new General("ANSWER_LIST", Server.getAllFoods());
                    oos.writeObject(packet2);
                }
                if(general.getCode().equals("ADD_MyBasket")){
                    Server.addMyBasket((MyBasket) general.getData());
                }

                if(general.getCode().equals("LIST_MyBaskets")){
                    General general2 = new General("ANSWER_LIST", Server.getAllMyBaskets((Long)general.getData()));
                    oos.writeObject(general2);
                }



            }
            ois.close();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


