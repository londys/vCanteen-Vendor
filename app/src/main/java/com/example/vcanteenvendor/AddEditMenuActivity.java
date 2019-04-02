package com.example.vcanteenvendor;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class AddEditMenuActivity extends AppCompatActivity {

    Button orderStatusButton; //ORDER STATUS
    Button menuButton; //MENU
    Button salesRecordButton; //SALES RECORD
    Button settingsButton; //SETTINGS

    Button backButton;
    Button deleteMenuButton;
    Switch toggle;

    RadioGroup foodTypeRadioGroup;
    RadioButton combiMainRadio;
    RadioButton combiBaseRadio;
    RadioButton alacarteRadio;
    TextInputLayout nameInputLayout;
    TextInputEditText nameInput;
    ImageView uploadImage;
    EditText priceInput;

    RequestOptions option = new RequestOptions().centerCrop();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_menu);


        orderStatusButton= (Button) findViewById(R.id.orderStatusButton);
        menuButton= (Button) findViewById(R.id.menuButton);
        salesRecordButton= (Button) findViewById(R.id.salesRecordButton);
        settingsButton= (Button) findViewById(R.id.settingsButton);

        backButton = (Button) findViewById(R.id.backButton);
        deleteMenuButton = (Button) findViewById(R.id.deleteMenuButton);
        toggle = (Switch)findViewById(R.id.availabilityToggle);

        foodTypeRadioGroup = findViewById(R.id.foodTypeRadioGroup);
        combiMainRadio = findViewById(R.id.combiMainRadio);
        combiBaseRadio = findViewById(R.id.combiBaseRadio);
        alacarteRadio = findViewById(R.id.alacarteRadio);
        nameInputLayout = (TextInputLayout) findViewById(R.id.nameInputLayout);
        nameInput = findViewById(R.id.nameInput);
        uploadImage = findViewById(R.id.uploadImage);
        priceInput= findViewById(R.id.priceInput);



        //////////////////////////////////////////   Retrieve every info from menu   //////////////////////////////////////

        nameInput.setText(getIntent().getStringExtra("foodName"));
        priceInput.setText(String.valueOf(getIntent().getIntExtra("price",0)));

        if(getIntent().getStringExtra("foodImageUrl") != null)
        Glide.with(this).load(getIntent().getStringExtra("foodImageUrl")).apply(option).into(uploadImage);

        String foodType = getIntent().getStringExtra("foodType");

        if(foodType != null) {
            foodTypeRadioGroup.clearCheck();
            if(foodType.equals("ALACARTE")){
                alacarteRadio.setChecked(true);

            } else if (foodType.equals("COMBINATION_BASE")){
                combiBaseRadio.setChecked(true);

            } else if (foodType.equals("COMBINATION_MAIN")){
                combiMainRadio.setChecked(true);

            }
        }

        String foodStatus = getIntent().getStringExtra("foodStatus");

        if(foodStatus != null){
            if(foodStatus.equals("AVAILABLE")){
                toggle.setChecked(true);

            } else if(foodStatus.equals("SOLD_OUT")){
                toggle.setChecked(false);

            }
        }






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



        /////////////////////////////

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        deleteMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(AddEditMenuActivity.this);

                dialog.setContentView(R.layout.dialog_red);

                final TextView title = (TextView) dialog.findViewById(R.id.dialogTitle);
                final TextView content = (TextView) dialog.findViewById(R.id.dialogContent);
                Button negativeButton = (Button) dialog.findViewById(R.id.negativeButton);
                Button positiveButton = (Button) dialog.findViewById(R.id.positiveButton);


                title.setText("Delete Menu");
                content.setText("\"insert menu name here\"");
                positiveButton.setText("delete");



                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(), "MENU DELETED!",  Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });

                dialog.show();

            }
        });



        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==false){

                    final Dialog dialog = new Dialog(AddEditMenuActivity.this);

                    dialog.setContentView(R.layout.dialog_red);

                    final TextView title = (TextView) dialog.findViewById(R.id.dialogTitle);
                    final TextView content = (TextView) dialog.findViewById(R.id.dialogContent);
                    Button negativeButton = (Button) dialog.findViewById(R.id.negativeButton);
                    Button positiveButton = (Button) dialog.findViewById(R.id.positiveButton);


                    title.setText("Closing Menu");
                    content.setText("Awaiting orders for this menu\n" +
                            "will be cancelled immediately.\n" +
                            "\n" +
                            "Are you sure?");
                    positiveButton.setText("close menu");


                    negativeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    positiveButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(getApplicationContext(), "MENU CLOSED!",  Toast.LENGTH_SHORT).show();
                            dialog.dismiss();

                        }
                    });

                    dialog.show();

                }
            }
        });


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

    ////////////////////

    public void goToAddEdit() {
        Intent intent = new Intent(this, AddEditMenuActivity.class);
        startActivity(intent);
    }
}
