package com.example.vcanteenvendor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SalesRecordAdapter extends ArrayAdapter {
    private Activity context;
    private String[] name;
    private String[] extra;
    private String[] price;

    SalesRecordAdapter(Activity context, String[] name, String[] extra, String[] price ){

        super(context, R.layout.sales_record_row_relative , name);
        this.context = context;
        this.name=name;
        this.extra=extra;
        this.price=price;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater orderInflater = LayoutInflater.from(getContext());
        View customView = orderInflater.inflate(R.layout.sales_record_row_relative, parent, false);

        String singleItem = (String) getItem(position);
        TextView foodname = (TextView) customView.findViewById(R.id.foodName);
        TextView foodextra = (TextView) customView.findViewById(R.id.foodExtra);
        TextView foodprice = (TextView) customView.findViewById(R.id.foodPrice);

        foodname.setText(name[position]);
        foodextra.setText(extra[position]);
        foodprice.setText(price[position]);
        return customView;
    }
}
