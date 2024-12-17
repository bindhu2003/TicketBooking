package com.example.onlineticketbookingapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MovieBookingActivity extends AppCompatActivity {

    private static final String TAG = "MovieBookingActivity";

    private TextView movieTextView, dateTextView, timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_booking);

        // Initialize the TextViews
        movieTextView = findViewById(R.id.movieTextView);
        dateTextView = findViewById(R.id.dateTextView);
        timeTextView = findViewById(R.id.timeTextView);

        // Set default text for movie (if you have a movie selected, update this)
        movieTextView.setText("Movie Name");

        // Date picker dialog when user clicks on the Date TextView
        dateTextView.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MovieBookingActivity.this,
                    (view, year, month, dayOfMonth) -> dateTextView.setText(dayOfMonth + "/" + (month + 1) + "/" + year),
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            datePickerDialog.show();
        });

        // Time picker dialog when user clicks on the Time TextView
        timeTextView.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    MovieBookingActivity.this,
                    (view, hourOfDay, minute) -> timeTextView.setText(hourOfDay + ":" + minute),
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true
            );
            timePickerDialog.show();
        });

        // Booking button click listener
        Button btnSelectMovie = findViewById(R.id.btnSelectMovie);
        btnSelectMovie.setOnClickListener(v -> {
            Log.d(TAG, "Booking Button Clicked");

            // Intent to pass data to BookingConfirmationActivity
            Intent intent = new Intent(MovieBookingActivity.this, BookingConfirmationActivity.class);

            // Passing selected data to BookingConfirmationActivity
            intent.putExtra("MOVIE_NAME", movieTextView.getText().toString());
            intent.putExtra("DATE", dateTextView.getText().toString());
            intent.putExtra("TIME", timeTextView.getText().toString());

            startActivity(intent);
        });
    }
}
