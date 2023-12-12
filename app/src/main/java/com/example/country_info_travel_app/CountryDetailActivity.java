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
        TextView capital = findViewById(R.id.capital);
        TextView population = findViewById(R.id.population);
        TextView area = findViewById(R.id.area);
        TextView region = findViewById(R.id.region);
        TextView subregion = findViewById(R.id.subregion);

        Intent intent = getIntent();
        String nameString = intent.getStringExtra("name");
        String flagUrl = intent.getStringExtra("flagUrl");
        String capitalString = intent.getStringExtra("capital");
        int populationInt = intent.getIntExtra("population", 0);
        double areaDouble = intent.getDoubleExtra("area", 0.0);
        String regionString = intent.getStringExtra("region");
        String subregionString = intent.getStringExtra("subregion");

        name.setText(nameString);
        capital.setText(capitalString);
        population.setText(String.valueOf(populationInt));
        area.setText(String.valueOf(areaDouble));
        region.setText(regionString);
        subregion.setText(subregionString);

        // Load image with glide
        Glide.with(this).load(flagUrl).into(flag);
    }
}