package com.example.onlineticketbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);  // Assuming you have a splash screen layout

        // Navigate to HomepageActivity after 2 seconds
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, HomepageActivity.class);
            startActivity(intent);
            finish();
        }, 2000);  // 2000 milliseconds = 2 seconds
    }
}
