package com.example.vcanteenvendor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SalesRecordAdapter extends ArrayAdapter<SalesRecordArrayList> {


    public SalesRecordAdapter (Context context, ArrayList<SalesRecordArrayList> salesRecordList) {
        super(context, 0, salesRecordList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        SalesRecordArrayList item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.sales_record_row, parent, false);
        }
        // Lookup view for data population
        TextView foodid = (TextView) convertView.findViewById(R.id.foodId);
        TextView foodname = (TextView) convertView.findViewById(R.id.foodName);
        TextView foodextra = (TextView) convertView.findViewById(R.id.foodExtra);
        TextView foodprice = (TextView) convertView.findViewById(R.id.foodPrice);
        // Populate the data into the template view using the data object
        foodid.setText(item.foodId);
        foodname.setText(item.foodName);
        foodextra.setText(item.foodExtra);
        foodprice.setText(item.foodPrice);
        // Return the completed view to render on screen
        return convertView;
    }














































    /*private Activity context;
    private ArrayList<SalesRecordActivity.salesRecordArrayList> salesRecordArrayList;
    //private String[] name;
    //private String[] extra;
    //private String[] price;

   public SalesRecordAdapter(Activity context, ArrayList<SalesRecordActivity.salesRecordArrayList> salesRecordArrayList ){

        super(context, R.layout.sales_record_row_relative , salesRecordArrayList);
        this.context = context;
        //this.name= name.toArray(new String[0]);
        this.salesRecordArrayList=salesRecordArrayList;
        //this.price= price.toArray(new String[0]);
    }
    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return salesRecordArrayList.size();
    }

    @Override
    public SalesRecordActivity.salesRecordArrayList getItem(int position) {
        return salesRecordArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Get the data item for this position
        SalesRecordActivity.salesRecordArrayList sales = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.sales_record_row_relative, parent, false);
        }
        // Lookup view for data population
        TextView foodname = (TextView) convertView.findViewById(R.id.foodName);
        TextView foodextra = (TextView) convertView.findViewById(R.id.foodExtra);
        TextView foodprice = (TextView) convertView.findViewById(R.id.foodPrice);
        // Populate the data into the template view using the data object
        foodname.setText(SalesRecordActivity.salesRecordArrayList.);
        foodprice.setText(user.hometown);
        foodextra
        // Return the completed view to render on screen
        return convertView;*/



        /*String singleItem = (String) getItem(position);
        TextView foodname = (TextView) customView.findViewById(R.id.foodName);
        TextView foodextra = (TextView) customView.findViewById(R.id.foodExtra);
        TextView foodprice = (TextView) customView.findViewById(R.id.foodPrice);

        foodname.setText(name[position]);
        foodextra.setText(extra[position]);
        foodprice.setText(price[position]);
        return customView;
    }*/


    public int getItemCount () {
        return 0;
    }
}
