package com.company.addComponents;

import java.io.Serializable;

public class Food implements Serializable {
    private Long id;
    private String name;
    private String ingredients;
    private String cooking;
    private String category;
    private int count = 0;
    private int ratingCount = 0;
    private double ratingAverage = 0;



    public Food(String category) {
        this.category = category;
    }

    public Food(Long id,String name, String ingredients, String cooking, String category, int count, int ratingCount, double ratingAverage) {
        this.id=id;
        this.name = name;
        this.ingredients = ingredients;
        this.cooking = cooking;
        this.category = category;
        this.count = count;
        this.ratingCount = ratingCount;
        this.ratingAverage = ratingAverage;
    }

    public Food(String name, String ing, String cook, String category, int count, int ratingCount, double ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public Food(int ratingCount) {
        this.ratingCount = ratingCount;
    }
    public Food(Long id, String name, int count, String category) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.category = category;
    }
    public Food(Long id, String author, String name, String ingredients, String cooking, String category, int count, int ratingCount, double ratingAverage) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.cooking = cooking;
        this.category = category;
        this.count = count;
        this.ratingCount = ratingCount;
        this.ratingAverage = ratingAverage;
    }

    public Food(Long id, String name, String ingredients,String cooking,String category){
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.cooking = cooking;
        this.category = category;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public void setIngredients(String ing) {
        this.ingredients = ingredients;
    }
    public String getCooking() {
        return cooking;
    }
    public void setCooking(String cooking) {
        this.cooking = cooking;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getRatingCount() {
        return ratingCount;
    }
    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }
    public double getRatingAverage() {
        return ratingAverage;
    }
    public void setRatingAverage(double ratingAverage) {
        this.ratingAverage = ratingAverage;
    }
    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ing='" + ingredients + '\'' +
                ", cook='" + cooking + '\'' +
                ", category='" + category + '\'' +
                ", count=" + count +
                ", ratingCount=" + ratingCount +
                ", ratingAverage=" + ratingAverage +
                '}';
    }
}

