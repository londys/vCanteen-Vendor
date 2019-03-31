package com.example.vcanteenvendor;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SettingsActivity extends AppCompatActivity {


    Button orderStatusButton; //ORDER STATUS
    Button menuButton; //MENU
    Button salesRecordButton; //SALES RECORD
    Button settingsButton; //SETTINGS

    Button signOutButton;
    Switch vendorStatusToggle;
    TextView statusText;
    TextView vendorProfile;

    EditText vendorNameInput;
    EditText vendorEmailInput;

    TextView checkCUNex;
    TextView checkScb;
    TextView checkKplus;
    TextView checkTrueMoney;

    private RequestQueue mQueue;
    private String url="FROM ENDPOINTS";

    Vendor vendor = new Vendor();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        orderStatusButton= (Button) findViewById(R.id.orderStatusButton);
        menuButton= (Button) findViewById(R.id.menuButton);
        salesRecordButton= (Button) findViewById(R.id.salesRecordButton);
        settingsButton= (Button) findViewById(R.id.settingsButton);

        signOutButton=(Button) findViewById(R.id.signOutButton);
        vendorStatusToggle = (Switch) findViewById(R.id.vendorStatusToggle);
        statusText = (TextView) findViewById(R.id.statusText);

        vendorNameInput = (EditText) findViewById(R.id.vendorNameInput);
        vendorEmailInput = (EditText) findViewById(R.id.vendorEmailInput);

        vendorProfile = (TextView) findViewById(R.id.vendorProfile);

        checkCUNex = (TextView) findViewById(R.id.checkCUNex);
        checkScb = (TextView) findViewById(R.id.checkScb);
        checkKplus = (TextView) findViewById(R.id.checkKplus);
        checkTrueMoney = (TextView) findViewById(R.id.checkTrueMoney);


        //////////////////////////////////////////   JSON START UP   //////////////////////////////////////



        //mQueue = Volley.newRequestQueue(this);
        //accountJSONLoadUp(url);


        //accountJSONLoadUp();
        //testPut();

        testGet();





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

        salesRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSalesRecord();
            }
        });

        /*settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSettings();
            }
        });*/


        signOutButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(SettingsActivity.this);
                //dialog.setTitle("Devahoy");
                dialog.setContentView(R.layout.dialog_red);

                final TextView title = (TextView) dialog.findViewById(R.id.dialogTitle);
                final TextView content = (TextView) dialog.findViewById(R.id.dialogContent);
                Button negativeButton = (Button) dialog.findViewById(R.id.negativeButton);
                Button positiveButton = (Button) dialog.findViewById(R.id.positiveButton);


                content.setText("Log out of vCanteen?");
                content.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/SF-Pro-Text-Bold.otf"));
                positiveButton.setText("LOG OUT");
                title.setVisibility(View.GONE);


                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        logOut();
                        Toast.makeText(getApplicationContext(), "LOG OUT SUCCESS!",  Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });

                dialog.show();

            }
        });


        vendorStatusToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {

                if(isChecked==false){



                    final Dialog dialog = new Dialog(SettingsActivity.this);

                    dialog.setContentView(R.layout.dialog_red);

                    final TextView title = (TextView) dialog.findViewById(R.id.dialogTitle);
                    final TextView content = (TextView) dialog.findViewById(R.id.dialogContent);
                    Button negativeButton = (Button) dialog.findViewById(R.id.negativeButton);
                    Button positiveButton = (Button) dialog.findViewById(R.id.positiveButton);


                    title.setText("Closing Menu");
                    content.setText(R.string.closing_vendor);
                    positiveButton.setText("close menu");
                    //content.setGravity(Gravity.LEFT);


                    negativeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            vendorStatusToggle.setChecked(true);
                            dialog.dismiss();
                        }
                    });

                    positiveButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(getApplicationContext(), "MENU CLOSED!",  Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            statusText.setText("CLOSED");
                            statusText.setTextColor(Color.parseColor("#828282"));

                        }
                    });

                    dialog.show();

                } else {

                    statusText.setText("OPEN");
                    statusText.setTextColor(getResources().getColor(R.color.pinkPrimary));
                }

            }
        });





    }

    private void testGet() {

        url="https://vcanteen.herokuapp.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<OrderList> call = jsonPlaceHolderApi.getOrder(1);

        call.enqueue(new Callback<OrderList>() {
            @Override
            public void onResponse(Call<OrderList> call, Response<OrderList> response) {

                if (!response.isSuccessful()) {
                    vendorNameInput.setText("Code: " + response.code());
                    return;
                }

                OrderList orderList = response.body();
                vendorProfile.append(orderList.getEachOrder());
                /*vendorNameInput.setText(vendor.getVendorName());
                vendorEmailInput.setText(vendor.getVendorEmail());*/


            }

            @Override
            public void onFailure(Call<OrderList> call, Throwable t) {
                vendorProfile.setText(t.getMessage());
                System.out.println("\n\n\n\n********************"+ t.getMessage() +"********************\n\n\n\n");

            }
        });

    }

    private void testPut() {

        url="https://api.jsonbin.io/";

        vendor.setVendorEmail("kuy");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<Vendor> call = jsonPlaceHolderApi.getVendor2(1, vendor);

        call.enqueue(new Callback<Vendor>() {
            @Override
            public void onResponse(Call<Vendor> call, Response<Vendor> response) {

                if (!response.isSuccessful()) {
                    vendorNameInput.setText("Code: " + response.code());
                    return;
                }

                vendor = response.body();
                vendorNameInput.setText(vendor.getVendorName());
                vendorEmailInput.setText(vendor.getVendorEmail());

                /*if(vendor.findServiceProviderFromList(vendor.getVendorPaymentMethod())){
                    checkCUNex.setVisibility(View.VISIBLE);
                    vendorProfile.setText(vendor.getVendorPaymentMethod().toString());
                }*/


            }

            @Override
            public void onFailure(Call<Vendor> call, Throwable t) {
                vendorProfile.setText(t.getMessage());
                //System.out.println("\n\n\n\n"+ t.getMessage() +"\n\n\n\n");

            }
        });


    }

    private void accountJSONLoadUp() {

        url="https://api.jsonbin.io/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<Vendor> call = jsonPlaceHolderApi.getVendor(1);

        call.enqueue(new Callback<Vendor>() {
            @Override
            public void onResponse(Call<Vendor> call, Response<Vendor> response) {

                if (!response.isSuccessful()) {
                    vendorNameInput.setText("Code: " + response.code());
                    return;
                }

                vendor = response.body();
                vendorNameInput.setText(vendor.getVendorName());
                vendorEmailInput.setText(vendor.getVendorEmail());

                if(vendor.findServiceProviderFromList(vendor.getVendorPaymentMethod(), "CU_NEX")){
                    checkCUNex.setVisibility(View.VISIBLE);
                    //vendorProfile.setText(vendor.getVendorPaymentMethod().toString());
                }

                if(vendor.findServiceProviderFromList(vendor.getVendorPaymentMethod(), "SCB_EASY")){
                    checkScb.setVisibility(View.VISIBLE);
                }

                if(vendor.findServiceProviderFromList(vendor.getVendorPaymentMethod(), "K_PLUS")){
                    checkKplus.setVisibility(View.VISIBLE);
                }

                if(vendor.findServiceProviderFromList(vendor.getVendorPaymentMethod(), "TRUEMONEY_WALLET")){
                    checkTrueMoney.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void onFailure(Call<Vendor> call, Throwable t) {
                vendorProfile.setText(t.getMessage());
                //System.out.println("\n\n\n\n"+ t.getMessage() +"\n\n\n\n");

            }
        });

        /*JSONObject postparams = new JSONObject();
        try {
            postparams.put("vendorID", "00001"); //vendorId get from other source later
        } catch (JSONException e) {
            e.printStackTrace();
        }*/


        /*JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("vendorPaymentMethod");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject vendorPaymentMethod = jsonArray.getJSONObject(i);
                                String account = vendorPaymentMethod.getString("account");


                                *//*mTextViewResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");*//*
                            }


                            vendorNameInput.setText(response.getString("vendorName"));
                            vendorEmailInput.setText(response.getString("vendorEmail"));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);*/

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

    public void goToSalesRecord() {
        Intent intent = new Intent(this, SalesRecordActivity.class);
        startActivity(intent);
    }

   /* public void goToSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }*/

   public void logOut(){
       Intent intent = new Intent(this, LoginActivity.class);
       startActivity(intent);
   }

}
