package com.example.parcelableexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleItemsList = new ArrayList<>();
        exampleItemsList.add(new ExampleItem(R.drawable.ic_android, "Line1", "Line2"));
        exampleItemsList.add(new ExampleItem(R.drawable.ic_music, "Line3", "Line4"));
        exampleItemsList.add(new ExampleItem(R.drawable.ic_sun, "Line5", "Line6"));

        RecyclerView recyclerView = findViewById(R.id.item_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ExampleAdapter exampleAdapter = new ExampleAdapter( exampleItemsList, MainActivity.this);
        recyclerView.setAdapter(exampleAdapter);
        //For Parcelable code.
        exampleAdapter.setOnClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Extra parcelable", exampleItemsList.get(position));
                startActivity(intent);
            }
        });
    }
}