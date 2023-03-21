package com.example.noamoropenmic;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class barAdapter extends RecyclerView.Adapter <BarViewHolder> {
    List<Barlist> Bars;
    public barAdapter(List<Barlist> bars) {
        Bars = bars;
    }

    @NonNull
    @Override
    public BarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bar,parent,false);
        BarViewHolder viewHolder = new BarViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BarViewHolder holder, int position) {
        Barlist barlist = Bars.get(position);
        holder.barImage.setImageResource(barlist.getImage());
        holder.barName.setText(barlist.getName());
        holder.phone.setText(barlist.getPhoneNumber());
        holder.address.setText(barlist.getAddress());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MainActivity3.class);
                intent.putExtra("Barlist",barlist);
                ActivityOptionsCompat option = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        (Activity) view.getContext(),
                        holder.barImage,
                        "BarTransition"
                );

                view.getContext().startActivity(intent, option.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return Bars.size();
    }
}

//this tells our adapter that our view is of type BarViewHolder