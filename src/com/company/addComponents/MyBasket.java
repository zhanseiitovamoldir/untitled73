package com.company.addComponents;

import java.io.Serializable;

public class MyBasket implements Serializable {
    private int userid;
    private String name;
    private String ingredients;
    private String cooking;

    public MyBasket(int id, Long aLong, String name, String ingredients, String cooking){}

    public MyBasket(int userid, String name, String ingredients, String cooking) {
        this.userid = userid;
        this.name = name;
        this.ingredients = ingredients;
        this.cooking = cooking;
    }

    public MyBasket(Long userid, String name, String ingredients, String cooking) {
    }

    public MyBasket(String name, String ingredients, String cooking) {

        this.name = name;
        this.ingredients = ingredients;
        this.cooking = cooking;
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int id) {
        this.userid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCooking() {
        return cooking;
    }

    public void setCooking(String cooking) {
        this.cooking = cooking;
    }
}

