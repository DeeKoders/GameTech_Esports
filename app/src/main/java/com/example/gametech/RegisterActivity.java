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
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



    }

    public void Register(View view){
        EditText email = findViewById(R.id.email_address);
        EditText password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        if(email.getText().toString().equals(""))
        {
            Toast.makeText(RegisterActivity.this, "EMPTY FIELDS !!", Toast.LENGTH_LONG).show();


        }
        else {
            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "User Created Successfully !!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(RegisterActivity.this, "User Not Created !!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
}
