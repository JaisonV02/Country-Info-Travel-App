package com.example.country_info_travel_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CountryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        ImageView flag = findViewById(R.id.flag);
        TextView name = findViewById(R.id.name);

        Intent intent = getIntent();
        String nameString = intent.getStringExtra("name");
        String flagUrl = intent.getStringExtra("flagUrl");

        name.setText(nameString);

        // Load image with glide
        Glide.with(this).load(flagUrl).into(flag);
    }
}