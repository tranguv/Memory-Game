package com.example.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Rule_Layout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rule);

        Button button = (Button) findViewById(R.id.returnHomeRule);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
        });
    }
}
