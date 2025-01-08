package com.example.onlineticketbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // Initialize buttons
        Button btnTemples = findViewById(R.id.btnTemples);
        Button btnTheatres = findViewById(R.id.btnTheatres);
        Button btnTourist = findViewById(R.id.btnTourist);
        Button btnRestaurants = findViewById(R.id.btnRestaurants);

        // Set click listeners for each button
        btnTemples.setOnClickListener(view -> {
            // Navigate to Temple Booking Activity
            Intent intent = new Intent(HomepageActivity.this, TempleBookingActivity.class);
            startActivity(intent);
        });

        btnTheatres.setOnClickListener(view -> {
            // Navigate to Theatre Booking Activity
            Intent intent = new Intent(HomepageActivity.this, TheatreBookingActivity.class);
            startActivity(intent);
        });

        btnTourist.setOnClickListener(view -> {
            // Navigate to Tourist Places Booking Activity
            Intent intent = new Intent(HomepageActivity.this, TouristBookingActivity.class);
            startActivity(intent);
        });

        btnRestaurants.setOnClickListener(view -> {
            // Navigate to Restaurant Booking Activity
            Intent intent = new Intent(HomepageActivity.this, RestaurantBookingActivity.class);
            startActivity(intent);
        });
    }
}
