package com.example.madprojectassign3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class bank extends AppCompatActivity {

    private ImageView tvOpenActivity213;
    private Button continueButton;
    private EditText bankAccountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank);


        tvOpenActivity213 = findViewById(R.id.tvOpenActivity213);  // Back button (ImageView)
        continueButton = findViewById(R.id.continueButton);  // Continue button
        bankAccountEditText = findViewById(R.id.editTextBankAccountNumber);


        tvOpenActivity213.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent backIntent = new Intent(bank.this, category.class);
                startActivity(backIntent);
            }
        });


        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bankAccountNumber = bankAccountEditText.getText().toString().trim();


                if (bankAccountNumber.length() != 11) {

                    Toast.makeText(bank.this, "Bank account number must be 11 characters long.", Toast.LENGTH_SHORT).show();
                } else {

                    Intent continueIntent = new Intent(bank.this, Home_page.class);
                    startActivity(continueIntent);

                }
            }
        });

    }
}
