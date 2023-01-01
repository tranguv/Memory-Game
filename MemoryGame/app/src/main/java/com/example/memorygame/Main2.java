package com.example.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main2 extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseboard);

        Button button = (Button) findViewById(R.id.easy_button);
        button.setOnClickListener((View.OnClickListener) this) ;

        button1 = (Button) findViewById(R.id.med_button);
        button.setOnClickListener((View.OnClickListener) this);

        button2 = (Button) findViewById(R.id.hard_button);
        button.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.easy_button:
                Intent intent = new Intent(Main2.this, EasyMode.class);
                startActivity(intent);
                break;
            case R.id.med_button:
                Intent intent1 = new Intent(Main2.this, MedMode.class);
                startActivity(intent1);
                break;
            case R.id.hard_button:
                Intent intent2 = new Intent(Main2.this, HardMode.class);
                startActivity(intent2);
                break;
            case R.id.back_button:
                Intent intent3 = new Intent(Main2.this, Main.class);
                startActivity(intent3);
                break;
        }

    }



}
