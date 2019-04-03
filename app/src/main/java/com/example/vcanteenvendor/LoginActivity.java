package com.example.vcanteenvendor;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button forgotpwbutton = (Button) findViewById(R.id.forgot_pw_button);
        forgotpwbutton.setPaintFlags(forgotpwbutton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        Button loginbutton = (Button) findViewById(R.id.login_button);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        ImageView chefpic = findViewById(R.id.chefpic);
        RequestOptions option = new RequestOptions().centerCrop();
        Glide.with(LoginActivity.this).load(R.drawable.hero_image).apply(option).into(chefpic);
    }
}
