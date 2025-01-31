package com.example.madprojectassign3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class product_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_page);


        ImageView rootLayout = findViewById(R.id.buynow1);
        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(product_page.this, address.class);
                startActivity(intent);
            }
        });


        ImageView secondAction = findViewById(R.id.goback_button);
        secondAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(product_page.this, Home_page.class);
                startActivity(newIntent);
            }
        });
    }
}
