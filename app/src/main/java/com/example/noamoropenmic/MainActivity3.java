package com.example.noamoropenmic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class  MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle b = getIntent().getExtras();
        Barlist barlist = (Barlist) b.getSerializable("Barlist");

        ImageView barImage = findViewById(R.id.barImage);
        TextView address = findViewById(R.id.address);
        TextView barName = findViewById(R.id.barName);
        TextView phone = findViewById(R.id.phone);

        //barImage.setImageResource(barlist.getImage());
        barName.setText(barlist.getName());
        phone.setText(barlist.getPhoneNumber());
        address.setText(barlist.getAddress());

        FloatingActionButton mapbtn = findViewById(R.id.MapButton);
        mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Main_Activity5_Map = new Intent(view.getContext(),MainActivity5Map.class);
                startActivity(Main_Activity5_Map);
            }
        });

        Glide.with(this).load(barlist.getImage()).into(barImage);

    }
}

