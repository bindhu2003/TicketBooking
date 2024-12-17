package com.example.onlineticketbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);  // Layout with buttons

        Button btnTemples = findViewById(R.id.btnTemples);
        Button btnTheatres = findViewById(R.id.btnTheatres);
        Button btnTouristPlaces = findViewById(R.id.btnTouristPlaces);
        Button btnRestaurants = findViewById(R.id.btnRestaurants);

        // Set up click listeners for each button
        btnTemples.setOnClickListener(v -> {
            startActivity(new Intent(HomepageActivity.this, TempleBookingActivity.class));
        });

        btnTheatres.setOnClickListener(v -> {
            startActivity(new Intent(HomepageActivity.this, TheatreBookingActivity.class));
        });

        btnTouristPlaces.setOnClickListener(v -> {
            startActivity(new Intent(HomepageActivity.this, TouristBookingActivity.class));
        });

        btnRestaurants.setOnClickListener(v -> {
            startActivity(new Intent(HomepageActivity.this, RestaurantBookingActivity.class));
        });
    }
}
