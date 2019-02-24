package com.example.vcanteenvendor;

public class Menu {

    private String foodName;
    private int foodPrice;
    private int foodId;
    private int foodImg;

    public Menu(){

    }

    public Menu(String foodName, int foodPrice, int foodId, int foodImg) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodId = foodId;
        this.foodImg = foodImg;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(int foodImg) {
        this.foodImg = foodImg;
    }
}
