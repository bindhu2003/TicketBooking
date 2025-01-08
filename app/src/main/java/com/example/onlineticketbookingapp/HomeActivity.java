package com.example.onlineticketbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Update to ImageButton
        ImageButton btnTemple = findViewById(R.id.btnTemple);
        ImageButton btnTheatre = findViewById(R.id.btnTheatre);
        ImageButton btnTourism = findViewById(R.id.btnTourism);
        ImageButton btnRestaurant = findViewById(R.id.btnRestaurant);

        btnTemple.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, TempleBookingActivity.class);
            startActivity(intent);
        });

        btnTheatre.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, TheatreBookingActivity.class);
            startActivity(intent);
        });

        btnTourism.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, TouristBookingActivity.class);
            startActivity(intent);
        });

        btnRestaurant.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, RestaurantBookingActivity.class);
            startActivity(intent);
        });
    }
}
