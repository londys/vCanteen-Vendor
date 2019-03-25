package com.example.vcanteenvendor;

//////////////////////// get & set & constructor /////////////////////
public class SalesRecordArrayList{
    public String foodId, foodName, foodExtra, foodPrice;

    public SalesRecordArrayList(String foodId, String foodName, String foodExtra, String foodPrice){

        this.setFoodId(foodId);
        this.setFoodName(foodName);
        this.setFoodExtra(foodExtra);
        this.setFoodPrice(foodPrice);
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodExtra) {
        this.foodName = foodName;
    }

    public String getFoodExtra() {
        return foodExtra;
    }

    public void setFoodExtra(String foodExtra) {
        this.foodExtra = foodExtra;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String price) {
        foodPrice = price;
    }

}
