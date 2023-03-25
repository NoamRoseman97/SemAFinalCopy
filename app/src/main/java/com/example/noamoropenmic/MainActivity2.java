package com.example.noamoropenmic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<Barlist> bars = new ArrayList<>();
        bars.add(new Barlist(R.drawable.mikesplace, "Mike's Place","Herber Samuel 90","03 - 5106392"));
        bars.add(new Barlist(R.drawable.comedybar, "Comedy Bar","Shlomo ibn Gvirol 26","03 - 5607075"));
        bars.add(new Barlist(R.drawable.levontin, "Levontin 7","Levontin st 7","03 - 5605084"));
        bars.add(new Barlist(R.drawable.camel, "Camel Comedy","Allenby 128","03 - 5558321"));
        bars.add(new Barlist(R.drawable.ozen, "Ozen Bar","King George 48","03 - 6215210"));
        bars.add(new Barlist(R.drawable.giora, "Giora Bar","Shlomo ibn Gvirol 30","03 - 6711310"));
        bars.add(new Barlist(R.drawable.biggyz, "Biggy Z","Bograshov 18","03 - 5369582"));
        bars.add(new Barlist(R.drawable.dramabar, "Drama Bar","Nachalat Binyamin 52","054 - 7205899"));
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);

        barAdapter adapter = new barAdapter(bars);
        recyclerView.setAdapter(adapter);
    }
}

