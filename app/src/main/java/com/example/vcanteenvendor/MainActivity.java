package com.example.vcanteenvendor;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //Header Bar set fonts//
    Button b1; //ORDER STATUS
    Button b2; //MENU
    Button b3; //SALES RECORD
    Button b4; //SETTINGS
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

        b1= (Button) findViewById(R.id.button);
        b2= (Button) findViewById(R.id.button2);
        b3= (Button) findViewById(R.id.button3);
        b4= (Button) findViewById(R.id.button4);
        doneButton = (Button) findViewById(R.id.doneButton) ;
        cancelButton = (Button) findViewById(R.id.cancelButton);
        orderNo = (TextView) findViewById(R.id.orderNo);
        foodName = (TextView) findViewById(R.id.foodName);
        foodExtra = (TextView) findViewById(R.id.foodExtra);

        //set fonts from assets here
        Typeface light = Typeface.createFromAsset(getAssets(),"fonts/SF-Pro-Text-Light.otf");
        Typeface regular = Typeface.createFromAsset(getAssets(),"fonts/SF-Pro-Text-Regular.otf");
        Typeface medium = Typeface.createFromAsset(getAssets(),"fonts/SF-Pro-Text-Medium.otf");
        Typeface semibold = Typeface.createFromAsset(getAssets(),"fonts/SF-Pro-Text-Semibold.otf");
        Typeface bold = Typeface.createFromAsset(getAssets(),"fonts/SF-Pro-Text-Bold.otf");

        b1.setTypeface(semibold);
        b2.setTypeface(semibold);
        b3.setTypeface(semibold);
        b4.setTypeface(semibold);
        /*orderNo.setTypeface(regular);
        foodName.setTypeface(bold);
        foodExtra.setTypeface(regular);
        doneButton.setTypeface(semibold);
        cancelButton.setTypeface(semibold);
*/



        ///////////////////// Adapter /////////////////

        String[] test = {"Food1","Food2","Food3","Food4","Food5","Food6"};
        ListAdapter testAdapter = new OrderAdapter(this, test);
        ListView orderlist = findViewById(R.id.orderlist);
        orderlist.setAdapter(testAdapter);

    }
}
