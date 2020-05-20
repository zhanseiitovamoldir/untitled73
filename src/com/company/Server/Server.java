package com.company.Server;

import com.company.addComponents.Food;
import com.company.addComponents.MyBasket;
import com.company.addComponents.User;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class Server {
    public static Connection connection;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&serverTimezone=UTC","root", "");
            ServerSocket ss = new ServerSocket(2020);

            while(true){
                Socket s = ss.accept();
                ServerThread st = new ServerThread(s);
                st.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean registerUser(User user){
        int rows = 0;

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (id,name,surname, login, password, role) VALUES (null, ?, ?, ?, ?,?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setString(5, "USER");

            rows = statement.executeUpdate();
            statement.close();
        }
        catch(Exception e){e.printStackTrace();}

        if(rows == 1)
            return true;

        return false;
    }

    public static User loginUser(User user){
        User authUser = null;

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            ResultSet result = statement.executeQuery();

            if(result.next()){
                authUser = new User(
                        result.getInt ("id"),
                        result.getString("name"),
                        result.getString("surname"),
                        result.getString("login"),
                        result.getString("password"),
                        result.getString("role")
                );
            }
            statement.close();
        }
        catch(Exception e){e.printStackTrace();}

        return authUser;
    }

    public static ArrayList<Food> getAllFoods(){
        ArrayList<Food> foods=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM foods");
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                Long id=resultSet.getLong("id");
                String name=resultSet.getString("name");
                String ing=resultSet.getString("ing");
                String cook=resultSet.getString("cook");
                String category=resultSet.getString("category");

                foods.add(new Food(id, name, ing, cook, category));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }//////


    public static void addFood(Food food){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO foods (id, name, ing, cook, category) VALUES (null, ?, ?, ?, ?)");
            statement.setString(1, food.getName());
            statement.setString(2, food.getIngredients());
            statement.setString(3, food.getCooking());
            statement.setString(4, food.getCategory());
//            statement.setInt(3, food.getCount());
//            statement.setString(4, food.getCategory());
//            statement.setInt(5, 0);
//            statement.setDouble(6, 0);

            statement.executeUpdate();
            statement.close();
        }
        catch(Exception e){e.printStackTrace();}
    }  ///////

    public static ArrayList<Food> getFoodsByType(String c){ //g mojet byt literature ili scientific
        ArrayList<Food> foods=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM foods WHERE category=?");
            statement.setString(1, c);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                Long id=resultSet.getLong("id");
                String name=resultSet.getString("name");
                String ingredients=resultSet.getString("ing");
                String cooking=resultSet.getString("cook");
                String category =resultSet.getString("category");

                foods.add(new Food(id, name, ingredients,cooking,category));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    public static void addMyBasket(MyBasket myBasket){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO mybasket (userid, name,ingredients,cooking) VALUES (?,?,?,?)");
            statement.setInt(1, myBasket.getUserid());
            statement.setString(2, myBasket.getName());
            statement.setString(3, myBasket.getIngredients());
            statement.setString(4, myBasket.getCooking());

            statement.executeUpdate();
            statement.close();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static ArrayList<MyBasket> getAllMyBaskets(Long uid){
        ArrayList<MyBasket> myBaskets=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM mybasket WHERE userid=?");
            statement.setLong(1, uid);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                Long userid=resultSet.getLong("userid");
                String name=resultSet.getString("name");
                String ingredients=resultSet.getString("ingredients");
                String cooking=resultSet.getString("cooking");


                myBaskets.add(new MyBasket(name,ingredients,cooking));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myBaskets;
    }


}
