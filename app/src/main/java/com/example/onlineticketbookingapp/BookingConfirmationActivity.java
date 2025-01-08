package com.example.onlineticketbookingapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BookingConfirmationActivity extends AppCompatActivity {

    private TextView confirmationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);

        confirmationText = findViewById(R.id.confirmationText);

        // Get Intent Extras
        String userName = getIntent().getStringExtra("user_name");
        String numberOfTickets = getIntent().getStringExtra("number_of_tickets");
        String selectedDate = getIntent().getStringExtra("selected_date");
        String totalPrice = getIntent().getStringExtra("total_price");
        String category = getIntent().getStringExtra("category");

        // Fallback for null values
        if (userName == null) userName = "Guest";
        if (numberOfTickets == null) numberOfTickets = "0";
        if (totalPrice == null) totalPrice = "0";
        if (selectedDate == null) selectedDate = "N/A";
        if (category == null) category = "N/A";

        // Set Confirmation Text
        String confirmationMessage = "Booking Confirmed!\n\n" +
                "Name: " + userName + "\n" +
                "Category: " + category + "\n" +
                "Date: " + selectedDate + "\n" +
                "Tickets: " + numberOfTickets + "\n" +
                "Total Price: ₹" + totalPrice;

        confirmationText.setText(confirmationMessage);

        // Show Toast
        Toast.makeText(this, "Booking Confirmed for ₹" + totalPrice, Toast.LENGTH_LONG).show();
    }
}