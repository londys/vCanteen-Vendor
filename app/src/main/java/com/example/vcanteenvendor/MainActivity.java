package com.example.vcanteenvendor;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    Button orderStatusButton; //ORDER STATUS
    Button menuButton; //MENU
    Button salesRecordButton; //SALES RECORD
    Button settingsButton; //SETTINGS

    Button doneButton;
    Button cancelButton;
    TextView orderNo;
    TextView foodName;
    TextView foodExtra;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        orderStatusButton= (Button) findViewById(R.id.orderStatusButton);
        menuButton= (Button) findViewById(R.id.menuButton);
        salesRecordButton= (Button) findViewById(R.id.salesRecordButton);
        settingsButton= (Button) findViewById(R.id.settingsButton);

        doneButton = (Button) findViewById(R.id.doneButton) ;
        cancelButton = (Button) findViewById(R.id.cancelButton);
        orderNo = (TextView) findViewById(R.id.orderNo);
        foodName = (TextView) findViewById(R.id.foodName);
        foodExtra = (TextView) findViewById(R.id.foodExtra);

        //set fonts from assets here
        /*Typeface light = Typeface.createFromAsset(getAssets(),"fonts/SF-Pro-Text-Light.otf");
        Typeface regular = Typeface.createFromAsset(getAssets(),"fonts/SF-Pro-Text-Regular.otf");
        Typeface medium = Typeface.createFromAsset(getAssets(),"fonts/SF-Pro-Text-Medium.otf");
        Typeface semibold = Typeface.createFromAsset(getAssets(),"fonts/SF-Pro-Text-Semibold.otf");
        Typeface bold = Typeface.createFromAsset(getAssets(),"fonts/SF-Pro-Text-Bold.otf");

        orderStatusButton.setTypeface(semibold);
        menuButton.setTypeface(semibold);
        salesRecordButton.setTypeface(semibold);
        settingsButton.setTypeface(semibold);*/
        /*orderNo.setTypeface(regular);
        foodName.setTypeface(bold);
        foodExtra.setTypeface(regular);
        doneButton.setTypeface(semibold);
        cancelButton.setTypeface(semibold);
*/


        //////////////////////////////////////////   Navigation   //////////////////////////////////////

        /*orderStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });*/

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMenu();
            }
        });

        salesRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSalesRecord();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSettings();
            }
        });







        //////////////////////////////////////////   Order Adapter   //////////////////////////////////////

        String[] test = {"Fried Chicken with Sticky RiceFried Chicken with Sticky RiceFried Chicken with Sticky Rice","Fried Chicken with Sticky RiceFried Chicken with Sticky Rice","Food3","Food4","Fried Chicken with Sticky RiceFried Chicken with Sticky RiceFried Chicken with Sticky RiceFried Chicken with Sticky Rice","Food6"};

        List<Order> orderList = new ArrayList<Order>();

        ListAdapter testAdapter = new OrderAdapter(this, orderList); //Put the arraylist here
        ListView orderlist = findViewById(R.id.orderlist);
        orderlist.setAdapter(testAdapter);


        //orderLoadUp();



    }

    private void orderLoadUp() {

        String url="https://api.jsonbin.io/b/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Order>> call = jsonPlaceHolderApi.getOrders(1,"COOKING");

        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    //vendorNameInput.setText("Code: " + response.code());
                    return;
                }

                List<Order> orders = response.body();

                /*Vendor vendor = response.body();
                vendorNameInput.setText(vendor.getVendorName());
                vendorEmailInput.setText(vendor.getVendorEmail());*/
                // System.out.println("THE VENDOR NAME ISSS "+vendor.getVendorName());
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });

    }


    //////////////////////////////////////////   Navigation(cont.)   //////////////////////////////////////
    /*public void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/

    public void goToMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void goToSalesRecord() {
        Intent intent = new Intent(this, SalesRecordActivity.class);
        startActivity(intent);
    }

    public void goToSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }

}
