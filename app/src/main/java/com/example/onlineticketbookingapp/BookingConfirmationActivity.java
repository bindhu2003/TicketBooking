package com.example.onlineticketbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BookingConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);

        // Retrieve the data from the intent
        Intent intent = getIntent();
        String movieName = intent.getStringExtra("MOVIE_NAME");
        String date = intent.getStringExtra("DATE");
        String time = intent.getStringExtra("TIME");

        // Find the TextView and display the booking information
        TextView confirmationText = findViewById(R.id.confirmationText);
        confirmationText.setText("Booking Confirmed!\nMovie: " + movieName + "\nDate: " + date + "\nTime: " + time);
    }
}
