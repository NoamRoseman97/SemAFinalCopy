package com.example.noamoropenmic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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

        barImage.setImageResource(barlist.getImage());
        barName.setText(barlist.getName());
        phone.setText(barlist.getPhoneNumber());
        address.setText(barlist.getAddress());

    }
}