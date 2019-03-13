package com.example.vcanteenvendor;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuAlacarteRecyclerviewAdapter extends RecyclerView.Adapter<MenuAlacarteRecyclerviewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Menu> mData ;


    public MenuAlacarteRecyclerviewAdapter(Context mContext, List<Menu> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MenuAlacarteRecyclerviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.menu_card,parent,false);
        return new MenuAlacarteRecyclerviewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.card_food_name.setText(mData.get(position).getFoodName());
        holder.card_food_price.setText(String.format ("%d", mData.get(position).getFoodPrice()));
        holder.menuImg.setImageResource(mData.get(position).getFoodImg());
        /*holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,Book_Activity.class);

                // passing data to the book activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                // start the activity
                mContext.startActivity(intent);

            }
        });*/
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView card_food_name;
        TextView card_food_price;
        ImageView menuImg;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            card_food_name = (TextView) itemView.findViewById(R.id.card_food_name) ;
            card_food_price = (TextView) itemView.findViewById(R.id.card_food_price) ;
            menuImg = (ImageView) itemView.findViewById(R.id.menuImg);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}
