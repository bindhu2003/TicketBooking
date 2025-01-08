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

public class TempleBookingActivity extends AppCompatActivity {

    private EditText etNumberOfTickets;
    private TextView tvSelectedDate, tvPrice;
    private Button btnSelectDate, btnBookNow;

    private int ticketPrice = 100; // Price per ticket
    private String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple_booking);

        etNumberOfTickets = findViewById(R.id.etNumberOfTickets);
        tvSelectedDate = findViewById(R.id.tvSelectedDate);
        tvPrice = findViewById(R.id.tvPrice);
        btnSelectDate = findViewById(R.id.btnSelectDate);
        btnBookNow = findViewById(R.id.btnBookNow);

        // Date Picker
        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(TempleBookingActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                                tvSelectedDate.setText("Selected Date: " + selectedDate);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        // Calculate Price
        etNumberOfTickets.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculatePrice();
                }
            }
        });

        // Book Now
        btnBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    Intent intent = new Intent(TempleBookingActivity.this, BookingConfirmationActivity.class);
                    intent.putExtra("temple_name", "Temple Name"); // Replace with dynamic name
                    intent.putExtra("number_of_tickets", etNumberOfTickets.getText().toString());
                    intent.putExtra("selected_date", selectedDate);
                    intent.putExtra("total_price", tvPrice.getText().toString());
                    startActivity(intent);
                }
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
