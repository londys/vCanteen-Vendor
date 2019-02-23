package com.example.vcanteenvendor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

        String[] test = {"Food1","Food2","Food3","Food4","Food5","Food6"};
        ListAdapter testAdapter = new OrderAdapter(this, test);
        ListView orderlist = findViewById(R.id.orderlist);
        orderlist.setAdapter(testAdapter);

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

}
