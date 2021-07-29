package com.example.gametech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);




    }

    public void head(View view) {
        Intent intent = new Intent(CategoryActivity.this, ProductActivity.class);
        intent.putExtra("Name","Headphones");

    }
    public void mouse(View view) {
        Intent intent = new Intent(CategoryActivity.this, ProductActivity.class);
        intent.putExtra("Name","Mouse");

        startActivity(intent);

    }
    public void monitor(View view) {
        Intent intent = new Intent(CategoryActivity.this, ProductActivity.class);
        intent.putExtra("Name","Monitor");

    }
    public void pro(View view) {
        Intent intent = new Intent(CategoryActivity.this, ProductActivity.class);
        intent.putExtra("Name","Processor");

    }
    public void casing(View view) {
        Intent intent = new Intent(CategoryActivity.this, ProductActivity.class);
        intent.putExtra("Name","Casing");

    }
}
