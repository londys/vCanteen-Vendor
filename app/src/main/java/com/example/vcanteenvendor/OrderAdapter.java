package com.example.vcanteenvendor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class OrderAdapter extends ArrayAdapter {

    OrderAdapter(Context context, String[] a){
        super(context, R.layout.order_row , a);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater orderInflater = LayoutInflater.from(getContext());
        View customView = orderInflater.inflate(R.layout.order_row, parent, false);

        String singleItem = (String) getItem(position);
        TextView foodname = (TextView) customView.findViewById(R.id.foodName);
        TextView foodextra = (TextView) customView.findViewById(R.id.foodExtra);

        foodname.setText(singleItem);
        foodextra.setText(singleItem);
        return customView;
    }
}
