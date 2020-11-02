package com.example.zztmtm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class DigitalDice extends AppCompatActivity {
    private TextView txtDiceNumber;
    private ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_dice);
        txtDiceNumber=findViewById(R.id.txtDiceNumber);
        parent=findViewById(R.id.parent);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random= new Random();
                int number=random.nextInt(6)+1;
                txtDiceNumber.setText(String.valueOf(number));
            }
        });

    }
}