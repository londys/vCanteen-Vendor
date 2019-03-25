package com.example.vcanteenvendor;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SalesRecordActivity extends AppCompatActivity {

    private String url = "json url from endpoint";
    private ListView salesrecord;
    Button orderStatusButton; //ORDER STATUS
    Button menuButton; //MENU
    Button salesRecordButton; //SALES RECORD
    Button settingsButton; //SETTINGS

    TextView orderNo;
    TextView foodName;
    TextView foodExtra;
    TextView foodPrice;
    private ArrayList<SalesRecordArrayList> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_record);



        orderStatusButton= (Button) findViewById(R.id.orderStatusButton);
        menuButton= (Button) findViewById(R.id.menuButton);
        salesRecordButton= (Button) findViewById(R.id.salesRecordButton);
        settingsButton= (Button) findViewById(R.id.settingsButton);

        orderNo = (TextView) findViewById(R.id.orderNo);
        foodName = (TextView) findViewById(R.id.foodName);
        foodExtra = (TextView) findViewById(R.id.foodExtra);
        foodPrice = (TextView) findViewById(R.id.foodPrice);

        getSalesRecordArrayList();








        //////////////////////////////////////////   Navigation   //////////////////////////////////////
        orderStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMenu();
            }
        });

        /*salesRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSalesRecord();
            }
        });*/

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSettings();
            }
        });


        //String[] name = {"Fried Chicken with Sticky RiceFried Chicken with Sticky RiceFried Chicken with Sticky Rice","Sticky RiceFried Chicken with Sticky Rice","Food3","Food4","Fried Chicken with Sticky RiceFried Chicken with Sticky RiceFried Chicken with Sticky RiceFried Chicken with Sticky Rice","Food6"};
        //String[] price = {"20.-", "30.-", "40.-", "20.-", "30.-", "50.-" };
        /*ArrayList<String> price = new ArrayList<String>();
        price.add("20.-");
        price.add("90.-");
        price.add("2045.-");
        price.add("42.-");
        price.add("18.-");
        price.add("200.-");
        price.add("30.-");
        String[] extra = {"extra1","extra2", "extra3", "extra4", "extra5","extra6"};
        ArrayList<String> name = new ArrayList<String>();
        name.add("A");
        name.add("B");
        name.add("C");
        name.add("D");
        name.add("E");
        name.add("F");


        ListAdapter testAdapter = new SalesRecordAdapter(this, food);
        ListView salesRecordList = findViewById(R.id.salesRecordList);
        salesRecordList.setAdapter(testAdapter);*/
        // Construct the data source
        // Create the adapter to convert the array to views
        //UsersAdapter adapter = new UsersAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView
       // ListView listView = (ListView) findViewById(R.id.lvItems);
        //listView.setAdapter(adapter);

        //ArrayAdapter<SalesRecordArrayList> itemsAdapter = new ArrayAdapter<String>(this, R.layout.sales_record_row, item);


    }


    //////////////////////////////////////////   Navigation(cont.)   //////////////////////////////////////
    public void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    /*public void goToSalesRecord() {
        Intent intent = new Intent(this, SalesRecordActivity.class);
        startActivity(intent);
    }*/

    public void goToSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void getSalesRecordArrayList(){
        final ArrayList<SalesRecordArrayList> orders = new ArrayList<>();
        final SalesRecordAdapter itemsAdapter = new SalesRecordAdapter(this,orders);
        final ListView listView = (ListView) findViewById(R.id.salesRecordList);
        listView.setAdapter(itemsAdapter);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://heroku/vcanteenvendor/v1/sales-record/vendor/sales";

        JSONObject postparams = new JSONObject();
        try {
            postparams.put("vendorID", "00001"); //vendorId get from other source later
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequestSalesRecord = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray = null;
                        //parsing json that isn't an array (total sales & best seller details)
                        try {

                            JSONObject food_name_best_seller = response.getJSONObject("food_name_best_seller");
                            String food_name_best_seller_string = food_name_best_seller.getString("food_name_best_seller");
                            TextView food_name_best_seller_textview = findViewById(R.id.best_seller_dish);
                            food_name_best_seller_textview.setText(food_name_best_seller_string);

                            JSONObject amount_best_seller = new JSONObject((Map) response);
                            int amount_best_seller_int = amount_best_seller.getInt("amount_best_seller");
                            String amount_best_seller_string = Integer.toString(amount_best_seller_int);
                            TextView amount_best_seller_textview = findViewById(R.id.number_sold);
                            amount_best_seller_textview.setText(amount_best_seller_string);

                            JSONObject total_daily_sales = new JSONObject((Map) response);
                            int total_daily_sales_int = total_daily_sales.getInt("total_daily_sales");
                            String total_daily_sales_string = Integer.toString(total_daily_sales_int);
                            TextView total_daily_sales_textview = findViewById(R.id.total_sales);
                            total_daily_sales_textview.setText(total_daily_sales_string);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        try {
                            JSONArray foodArray = response.getJSONArray("food");
                            //parsing Json
                            for(int i=0;i<response.length();i++) {
                                JSONObject foodObject = foodArray.getJSONObject(i);
                                int orderId = foodObject.getInt("orderId");
                                String food_name_appended = foodObject.getString("food_name_appended");
                                String food_extra_appended = foodObject.getString("food_extra_appended");
                                int order_price = foodObject.getInt("order_price");

                                SalesRecordArrayList neworder = new SalesRecordArrayList(Integer.toString(orderId), food_name_appended,food_extra_appended,Integer.toString(order_price));
                                itemsAdapter.add(neworder);


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });
    }









}




