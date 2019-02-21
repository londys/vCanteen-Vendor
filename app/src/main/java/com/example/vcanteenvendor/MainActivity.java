package com.example.vcanteenvendor;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b= (Button) findViewById(R.id.button);
        Typeface myfonts = Typeface.createFromAsset(getAssets(),"fonts/SF-Pro-Text-Semibold.otf");
        b.setTypeface(myfonts);
    }
}
