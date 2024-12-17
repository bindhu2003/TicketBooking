package com.example.onlineticketbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Ensure this matches the layout file

        // Temples button click
        Button btnTemples = findViewById(R.id.btnTemples);
        btnTemples.setOnClickListener(v -> {
            // Navigate to the Temple booking screen
            Intent intent = new Intent(HomeActivity.this, TempleBookingActivity.class);
            startActivity(intent);
        });

        // Theatres button click
        Button btnTheatres = findViewById(R.id.btnTheatres);
        btnTheatres.setOnClickListener(v -> {
            // Navigate to the Theatre booking screen
            Intent intent = new Intent(HomeActivity.this, TheatreBookingActivity.class);
            startActivity(intent);
        });

        // Tourist Places button click
        Button btnTouristPlaces = findViewById(R.id.btnTouristPlaces);
        btnTouristPlaces.setOnClickListener(v -> {
            // Navigate to the Tourist Place booking screen
            Intent intent = new Intent(HomeActivity.this, TouristBookingActivity.class);
            startActivity(intent);
        });

        // Restaurants button click
        Button btnRestaurants = findViewById(R.id.btnRestaurants);
        btnRestaurants.setOnClickListener(v -> {
            // Navigate to the Restaurant booking screen
            Intent intent = new Intent(HomeActivity.this, RestaurantBookingActivity.class);
            startActivity(intent);
        });
    }
}
