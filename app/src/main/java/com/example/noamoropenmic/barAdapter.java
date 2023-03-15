package com.example.noamoropenmic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class barAdapter extends RecyclerView.Adapter <BarViewHolder> {
    @NonNull
    @Override
    public BarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bar,parent,false);
        BarViewHolder viewHolder = new BarViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BarViewHolder holder, int position) {
        holder.barImage.setImageResource(R.drawable.download);
        holder.barName.setText("Bar1");
        holder.phone.setText("03-0000000");
        holder.address.setText("tel aviv 23");
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}

//this tells our adapter that our view is of time BarViewHolder