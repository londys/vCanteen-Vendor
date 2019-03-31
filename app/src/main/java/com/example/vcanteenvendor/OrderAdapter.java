package com.example.vcanteenvendor;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class OrderAdapter extends ArrayAdapter {



    OrderAdapter(Context context, List<Order> orderList){

        super(context, R.layout.order_row_relative , orderList);
    }

    OrderAdapter(Context context, String[] orderList){

        super(context, R.layout.order_row_relative , orderList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater orderInflater = LayoutInflater.from(getContext());
        View customView = orderInflater.inflate(R.layout.order_row_relative, parent, false);

        //String singleItem = (String) getItem(position);
        Order singleItem = (Order) getItem(position);

        final TextView foodname = (TextView) customView.findViewById(R.id.foodName);
        TextView foodextra = (TextView) customView.findViewById(R.id.foodExtra);
        final Button cancelButton = (Button) customView.findViewById(R.id.cancelButton);



        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(getContext());
                //dialog.setTitle("Devahoy");
                dialog.setContentView(R.layout.dialog_cancel_order);

                final TextView title = (TextView) dialog.findViewById(R.id.dialogTitle);
                //final TextView content = (TextView) dialog.findViewById(R.id.dialogContent);
                Button negativeButton = (Button) dialog.findViewById(R.id.negativeButton);
                Button positiveButton = (Button) dialog.findViewById(R.id.positiveButton);
                final CheckBox dialogCheckbox = (CheckBox) dialog.findViewById(R.id.dialogCheckbox);
                final EditText reasonInput = (EditText) dialog.findViewById(R.id.reasonInput);


                positiveButton.setText("CONFIRM");
                //negativeButton.setVisibility(View.GONE);



                dialogCheckbox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(dialogCheckbox.isChecked()){
                            dialogCheckbox.setBackgroundResource(R.drawable.button_gradient_rounded);
                            dialogCheckbox.setTextColor(Color.WHITE);
                        }
                        if(!dialogCheckbox.isChecked()){
                            dialogCheckbox.setBackgroundResource(R.drawable.button_gradient_rounded_unchecked);
                            dialogCheckbox.setTextColor(Color.BLACK);
                        }

                    }
                });
                
                reasonInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(hasFocus & dialogCheckbox.isChecked()){

                            dialogCheckbox.setBackgroundResource(R.drawable.button_gradient_rounded_unchecked);
                            dialogCheckbox.setTextColor(Color.BLACK);
                            dialogCheckbox.setChecked(false);
                        }
                    }
                });

                /*System.out.println(dialogCheckbox.isChecked());
                if (dialogCheckbox.isChecked()) {

                    dialogCheckbox.setBackgroundResource(R.drawable.button_gradient_rounded_unchecked);
                    dialogCheckbox.setTextColor(Color.BLACK);
                    dialogCheckbox.setChecked(false);
                }*/


                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {




                        dialog.dismiss();

                    }
                });

                dialog.show();

            }
        });



        foodname.setText(singleItem.getOrderName());
        foodextra.setText(singleItem.getOrderNameExtra());
        return customView;
    }





}
