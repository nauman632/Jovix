package com.example.madprojectassign3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class firebase_login extends AppCompatActivity {

    private EditText emailInput, passwordInput;
    private TextView emailErrorText, passwordErrorText, newAccountText;
    private ImageView backButton;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firbase_login);

        firestore = FirebaseFirestore.getInstance();

        emailInput = findViewById(R.id.Email1);
        passwordInput = findViewById(R.id.Password2);
        emailErrorText = findViewById(R.id.emailErrorText);
        passwordErrorText = findViewById(R.id.passwordErrorText);
        newAccountText = findViewById(R.id.new_account);
        backButton = findViewById(R.id.back_button_login);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(firebase_login .this, firebase_sign_up.class);
                startActivity(intent);
                finish();
            }
        });

        Button loginButton = findViewById(R.id.myButton3);

        emailErrorText.setVisibility(View.GONE);
        passwordErrorText.setVisibility(View.GONE);


        loginButton.setOnClickListener(this::onLoginButtonClicked);


        newAccountText.setOnClickListener(view -> {
            Intent intent = new Intent(firebase_login.this, firebase_sign_up.class);
            startActivity(intent);
            finish();
        });
    }

    public void onLoginButtonClicked(View view) {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty() || !email.contains("@")) {
            emailErrorText.setText("Invalid email.");
            emailErrorText.setVisibility(View.VISIBLE);
            return;
        }
        if (password.isEmpty()) {
            passwordErrorText.setText("Password is required.");
            passwordErrorText.setVisibility(View.VISIBLE);
            return;
        }

        firestore.collection("users_sign_up5")
                .whereEqualTo("email", email)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && !task.getResult().isEmpty()) {
                        boolean isAuthenticated = false;
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String storedPassword = document.getString("password");
                            if (storedPassword != null && storedPassword.equals(password)) {
                                isAuthenticated = true;
                                break;
                            }
                        }
                        if (isAuthenticated) {
                            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(firebase_login.this, category.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(this, "Invalid credentials.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "No account found with this email.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error while logging in. Please try again.", Toast.LENGTH_SHORT).show();
                });
    }
}
