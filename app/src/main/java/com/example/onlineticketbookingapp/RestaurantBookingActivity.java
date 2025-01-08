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

public class RestaurantBookingActivity extends AppCompatActivity {

    private EditText etNumberOfGuests;
    private TextView tvSelectedDate, tvPrice;
    private Button btnSelectDate, btnBookNow;

    private int pricePerGuest = 500; // Price per guest
    private String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_booking);

        etNumberOfGuests = findViewById(R.id.etNumberOfGuests);
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

            DatePickerDialog datePickerDialog = new DatePickerDialog(RestaurantBookingActivity.this,
                    (view, year1, month1, dayOfMonth) -> {
                        selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                        tvSelectedDate.setText("Selected Date: " + selectedDate);
                    }, year, month, day);
            datePickerDialog.show();
        });

        // Calculate Price
        etNumberOfGuests.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) calculatePrice();
        });

        // Book Now
        btnBookNow.setOnClickListener(v -> {
            if (validateInputs()) {
                Intent intent = new Intent(RestaurantBookingActivity.this, BookingConfirmationActivity.class);
                intent.putExtra("restaurant_name", "Restaurant Name"); // Replace with dynamic name
                intent.putExtra("number_of_guests", etNumberOfGuests.getText().toString());
                intent.putExtra("selected_date", selectedDate);
                intent.putExtra("total_price", tvPrice.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void calculatePrice() {
        String guests = etNumberOfGuests.getText().toString();
        if (!guests.isEmpty()) {
            int numberOfGuests = Integer.parseInt(guests);
            int totalPrice = numberOfGuests * pricePerGuest;
            tvPrice.setText("Price: ₹" + totalPrice);
        }
    }

    private boolean validateInputs() {
        if (etNumberOfGuests.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter number of guests", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (selectedDate == null) {
            Toast.makeText(this, "Select a date", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
