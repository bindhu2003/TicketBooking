package com.example.onlineticketbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {
    private Button btnUPI, btnCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btnUPI = findViewById(R.id.btnUPI);
        btnCard = findViewById(R.id.btnCard);

        btnUPI.setOnClickListener(view -> {
            Toast.makeText(PaymentActivity.this, "Processing UPI Payment", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(PaymentActivity.this, BookingConfirmationActivity.class));
        });

        btnCard.setOnClickListener(view -> {
            Toast.makeText(PaymentActivity.this, "Processing Card Payment", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(PaymentActivity.this, BookingConfirmationActivity.class));
        });
    }
}
