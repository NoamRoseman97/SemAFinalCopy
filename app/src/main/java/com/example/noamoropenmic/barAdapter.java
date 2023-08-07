package com.example.noamoropenmic;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class barAdapter extends RecyclerView.Adapter <BarViewHolder> {

    private List <Barlist> Bars = new ArrayList<>();


    public barAdapter() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("bar")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Bars = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                try {
                                    Barlist m = new Barlist(
                                            document.get("barAdress").toString(),
                                            document.get("barImage").toString(),
                                            document.get("barName").toString(),
                                            document.get("barPhone").toString()
                                    );
                                    Bars.add(m);
                                } catch (Exception e) {
                                }
                            }
                            notifyDataSetChanged();
                        }
                    }
                });
        db.collection("bar").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                Bars = new ArrayList<>();
                for (DocumentSnapshot document : value.getDocuments()) {
                    try {
                        Barlist m = new Barlist(
                                document.get("barAddress").toString(),
                                document.get("barImage").toString(),
                                document.get("barName").toString(),
                                document.get("barPhone").toString()
                        );
                        Bars.add(m);
                    } catch (Exception e) {
                    }
                }
                notifyDataSetChanged();
            }
        });
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
        //holder.barImage.setImageResource(barlist.getImage());
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
        Glide.with(holder.barImage.getContext()).load(barlist.getImage()).into(holder.barImage);
    }

    @Override
    public int getItemCount() {
        return Bars.size();
    }
}

//this tells our adapter that our view is of tyvpe BarViewHolder