package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void calc(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

    public void square(View view) {
        Intent i = new Intent(this, square.class);
        startActivity(i);
    }
}