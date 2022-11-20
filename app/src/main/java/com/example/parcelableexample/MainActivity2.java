package com.example.parcelableexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        ExampleItem exampleItem = intent.getParcelableExtra("Extra parcelable");

        int imgRes = exampleItem.getImageResourceId();
        String line1 = exampleItem.getLine1();
        String line2 = exampleItem.getLine2();

        ImageView imageView = findViewById(R.id.iv_activity2);
        imageView.setImageResource(imgRes);
        TextView tv1 = findViewById(R.id.tv1_activity2);
        tv1.setText(line1);
        TextView tv2 = findViewById(R.id.tv2_activity2);
        tv2.setText(line2);
    }
}