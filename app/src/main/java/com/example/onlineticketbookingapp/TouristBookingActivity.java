package com.example.onlineticketbookingapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TouristBookingActivity extends AppCompatActivity {

    private EditText etNumberOfTickets;
    private TextView tvSelectedDate, tvPrice;
    private Button btnSelectDate, btnBookNow;

    private int ticketPrice = 200; // Price per ticket for tourist places
    private String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_booking);

        etNumberOfTickets = findViewById(R.id.etNumberOfTickets);
        tvSelectedDate = findViewById(R.id.tvSelectedDate);
        tvPrice = findViewById(R.id.tvPrice);
        btnSelectDate = findViewById(R.id.btnSelectDate);
        btnBookNow = findViewById(R.id.btnBookNow);

        // Date Picker
        btnSelectDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(TouristBookingActivity.this,
                    (view, year1, month1, dayOfMonth) -> {
                        selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                        tvSelectedDate.setText("Selected Date: " + selectedDate);
                    }, year, month, day);
            datePickerDialog.show();
        });

        // Calculate Price
        etNumberOfTickets.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) calculatePrice();
        });

        // Book Now
        btnBookNow.setOnClickListener(v -> {
            if (validateInputs()) {
                Intent intent = new Intent(TouristBookingActivity.this, BookingConfirmationActivity.class);
                intent.putExtra("tourist_place", "Tourist Place Name"); // Replace with dynamic name
                intent.putExtra("number_of_tickets", etNumberOfTickets.getText().toString());
                intent.putExtra("selected_date", selectedDate);
                intent.putExtra("total_price", tvPrice.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void calculatePrice() {
        String tickets = etNumberOfTickets.getText().toString();
        if (!tickets.isEmpty()) {
            int numberOfTickets = Integer.parseInt(tickets);
            int totalPrice = numberOfTickets * ticketPrice;
            tvPrice.setText("Price: ₹" + totalPrice);
        }
    }

    private boolean validateInputs() {
        if (etNumberOfTickets.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter number of tickets", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (selectedDate == null) {
            Toast.makeText(this, "Select a date", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
