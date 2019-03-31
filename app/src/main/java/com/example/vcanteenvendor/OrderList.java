package com.example.vcanteenvendor;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderList {

    @SerializedName("orderList")
    List<Order> orderList;

    public OrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "orderList=" + orderList +
                '}';
    }

    public String getEachOrder() {
        String content="";
        for (Order order: orderList){
            content += order.getOrderName()+" - ";
            content += order.getOrderNameExtra()+" --- ";
            /*content += "Order Name: "+order.getOrderName()+", ";
            content += "Order Name: "+order.getOrderNameExtra()+", ";*/
        }
        return content;
    }
}
