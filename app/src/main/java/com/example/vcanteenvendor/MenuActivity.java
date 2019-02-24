package com.example.vcanteenvendor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {


    Button orderStatusButton; //ORDER STATUS
    Button menuButton; //MENU
    Button salesRecordButton; //SALES RECORD
    Button settingsButton; //SETTINGS


    List<Menu> lstMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        orderStatusButton= (Button) findViewById(R.id.orderStatusButton);
        menuButton= (Button) findViewById(R.id.menuButton);
        salesRecordButton= (Button) findViewById(R.id.salesRecordButton);
        settingsButton= (Button) findViewById(R.id.settingsButton);



        //////////////////////////////////////////   Navigation   //////////////////////////////////////
        orderStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });

        /*menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMenu();
            }
        });*/

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



        lstMenu = new ArrayList<>();
        lstMenu.add(new Menu("Fried Chicken with Sticky Rice",300,0001,R.drawable.food_pic1));
        lstMenu.add(new Menu("Fried Chicken with Sticky RiceFried Chicken with Sticky RiceFried Chicken with Sticky Rice",450,0005,R.drawable.food_pic2));
        lstMenu.add(new Menu("Fried Chicken",50,0002,R.drawable.food_pic3));
        lstMenu.add(new Menu("Sticky Rice",10,0003,R.drawable.food_pic4));
        lstMenu.add(new Menu("Fried Chicken with Sticky Rice",120,0004,R.drawable.food_pic5));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.menuRecyclerView);
        MenuRecyclerviewAdapter myAdapter = new MenuRecyclerviewAdapter(this,lstMenu);
        myrv.setLayoutManager(new GridLayoutManager(this,5));
        myrv.setAdapter(myAdapter);


    }


    //////////////////////////////////////////   Navigation(cont.)   //////////////////////////////////////
    public void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /*public void goToMenu(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }*/

    public void goToSalesRecord() {
        Intent intent = new Intent(this, SalesRecordActivity.class);
        startActivity(intent);
    }

    public void goToSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
