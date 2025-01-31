package com.example.madprojectassign3;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class voucher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voucher);

        ImageView collectImageView = findViewById(R.id.collectImageView);
        collectImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(voucher.this, voucher_complete.class);
                startActivity(intent);
            }
        });
    }
}
