package com.example.madprojectassign3;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderConfirmed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_confirmed);


        ImageView voucherImageView = findViewById(R.id.voucherImageView);


        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);


        voucherImageView.startAnimation(fadeInAnimation);

        Button nextButton = findViewById(R.id.checkbox_orders);
        nextButton.setOnClickListener(view -> {

            Intent intent = new Intent(OrderConfirmed.this, Home_page.class);
            startActivity(intent);
        });
    }
}
