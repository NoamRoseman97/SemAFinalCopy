package com.example.noamoropenmic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class BarViewHolder extends RecyclerView.ViewHolder {

    public CardView cardView;
    public ImageView barImage;
    public TextView barName;
    public TextView phone;
    public TextView address;

    public BarViewHolder(@NonNull View itemView) {
        super(itemView);  //super so we can implement the parent class

        cardView = itemView.findViewById(R.id.cardview);
        barImage = itemView.findViewById(R.id.barImage);
        barName = itemView.findViewById(R.id.barName);
        phone = itemView.findViewById(R.id.phone);
        address = itemView.findViewById(R.id.address);


    }
}
