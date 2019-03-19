package com.example.vcanteenvendor;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button forgotpwbutton = (Button) findViewById(R.id.forgot_pw_button);
        forgotpwbutton.setPaintFlags(forgotpwbutton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
}
