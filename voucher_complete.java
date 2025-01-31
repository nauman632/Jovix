package com.example.madprojectassign3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class voucher_complete extends AppCompatActivity {

    private ImageView voucherImageView;
    private Button useVoucherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voucher_complete);

        voucherImageView = findViewById(R.id.voucherImageView);
        useVoucherButton = findViewById(R.id.useVoucherButton);

        // Simulate receiving a voucher
        onVoucherReceived();

        // Set a click listener for the button to navigate to the next screen
        useVoucherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the next screen (e.g., NextActivity)
                Intent intent = new Intent(voucher_complete.this, Home_page.class);
                startActivity(intent);
            }
        });
    }

    private void onVoucherReceived() {
        // Make the ImageView visible
        voucherImageView.setVisibility(View.VISIBLE);

        // Load the pop-up animation
        Animation popUp = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Start the animation
        voucherImageView.startAnimation(popUp);
    }
}
