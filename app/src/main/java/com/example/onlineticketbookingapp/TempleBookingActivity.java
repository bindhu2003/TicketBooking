package com.example.onlineticketbookingapp;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TempleBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple_booking);

        // Here you would implement booking functionality, such as selecting temple and booking tickets
        Toast.makeText(this, "Temple Booking Activity", Toast.LENGTH_SHORT).show();
    }
}
