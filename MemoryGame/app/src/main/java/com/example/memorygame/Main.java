package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    private Button button1;
    private Button button;
    private EditText nameInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyApplication myApplication = (MyApplication) getApplication();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        button = (Button) findViewById(R.id.start_game);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChooseMode();
            }
        });

        button1 = (Button) findViewById(R.id.rule_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRule();
            }
        });
    }
    public void openChooseMode (){
        Intent intent = new Intent(this,Main2.class);
        startActivity(intent);
    }

    public void openRule (){
        Intent intent = new Intent(this, Rule_Layout.class);
        startActivity(intent);
    }

}