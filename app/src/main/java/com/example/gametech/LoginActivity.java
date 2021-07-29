package com.example.gametech;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity{
    private FirebaseAuth mAuth;
    EditText email,password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }



    public void goToProduct(View view) {
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.signin_email);
        password= findViewById(R.id.signin_password);
        if(email.getText().toString().equals(""))
        {
            Toast.makeText(LoginActivity.this, "EMPTY FIELDS !!", Toast.LENGTH_LONG).show();

        }
        else {
            mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "User Logged In Successfully !!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, CategoryActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(LoginActivity.this, "Invalid Credentials !!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }
    }
}

