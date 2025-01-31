package com.example.madprojectassign3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class firebase_sign_up extends AppCompatActivity {

    private FirebaseFirestore firestore;
    private EditText editTextName, editTextEmail, editTextPassword, editTextConfirmPassword;
    private Button submitButton;
    private ImageView backButton;
    private TextView navigateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firbase_sign_up);

        firestore = FirebaseFirestore.getInstance();

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        submitButton = findViewById(R.id.submitButton);
        backButton = findViewById(R.id.back_button1);
        navigateTextView = findViewById(R.id.alreadyaccount);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(firebase_sign_up.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        navigateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the next activity
                Intent intent = new Intent(firebase_sign_up.this, firebase_login.class);
                startActivity(intent);
            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String confirmPassword = editTextConfirmPassword.getText().toString().trim();


                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(firebase_sign_up.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() || !email.endsWith("@gmail.com")) {
                    Toast.makeText(firebase_sign_up.this, "Email pattern is not correct. It must include '@gmail.com'", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (password.length() < 8) {
                    Toast.makeText(firebase_sign_up.this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(firebase_sign_up.this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                firestore.collection("users_sign_up5")
                        .whereEqualTo("email", email)
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                if (!queryDocumentSnapshots.isEmpty()) {

                                    Toast.makeText(firebase_sign_up.this, "This email is already in use", Toast.LENGTH_SHORT).show();
                                } else {

                                    saveUserData(name, email, password);
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(firebase_sign_up.this, "Failed to check email", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    private void saveUserData(String name, String email, String password) {

        Map<String, Object> user = new HashMap<>();
        user.put("name", name);
        user.put("email", email);
        user.put("password", password);
        firestore.collection("users_sign_up5").add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(firebase_sign_up.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();

                        editTextName.setText("");
                        editTextEmail.setText("");
                        editTextPassword.setText("");
                        editTextConfirmPassword.setText("");


                        Intent intent = new Intent(firebase_sign_up.this, firebase_login.class);
                        intent.putExtra("userName", name);
                        intent.putExtra("userEmail", email);
                        startActivity(intent);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(firebase_sign_up.this, "Failed to save data", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
