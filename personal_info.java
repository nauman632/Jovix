package com.example.madprojectassign3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class personal_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);

        ImageView backButton = findViewById(R.id.imageBack);


        backButton.setOnClickListener(v -> {

            onBackPressed();
        });

        Button nextButton = findViewById(R.id.collectImageView);


        nextButton.setOnClickListener(v -> {

            Intent intent = new Intent(personal_info.this, Home_page.class);
            startActivity(intent);
        });


        ImageView secondButton = findViewById(R.id.image11);

        secondButton.setOnClickListener(v -> {

            Intent intent = new Intent(personal_info.this, Home_page.class);
            startActivity(intent);
        });
    }
}
