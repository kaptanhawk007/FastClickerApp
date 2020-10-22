package com.example.zztmtm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnTouchSpeedChecker,btnDigitalDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiViews();
        btnTouchSpeedChecker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,TouchSpeedChecker.class);
                startActivity(intent);
            }
        });
        btnDigitalDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DigitalDice.class);
                startActivity(intent);
            }
        });
    }

    private void intiViews() {
        btnDigitalDice=findViewById(R.id.btnDigitalDice);
        btnTouchSpeedChecker=findViewById(R.id.btnTouchSpeedChecker);

    }
}