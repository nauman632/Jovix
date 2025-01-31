package com.example.madprojectassign3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);


        ImageView imageView = findViewById(R.id.tvOpenActivity3);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(category.this, firebase_login.class);
                startActivity(intent);
            }
        });

        Button continueButton = findViewById(R.id.myButton1n);
        continueButton.setOnClickListener(v -> {

            Intent intent = new Intent(category.this, bank.class);
            startActivity(intent);

        });
    }
}
