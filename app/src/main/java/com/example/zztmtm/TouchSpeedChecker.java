package com.example.zztmtm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TouchSpeedChecker extends AppCompatActivity {
    private TextView txtSpeed,txtTotalTouchRegistered,txtTimer,txtFinalSpeed,txtSpeedFinal;
    private RelativeLayout parent;
    private boolean touchStarted=true;
    private ImageView imageTimer,imageTimerCompleted;
    int taps=0;
    private ImageView btnInfo;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_speed_checker);
        final InfoDialogue dialogue=new InfoDialogue();
//        dialogue.show(getSupportFragmentManager(),"Info";

        initViews();
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogue.show(getSupportFragmentManager(),"Info");
            }
        });

        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fullMethod();
            }
        });

        parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                taps=0;
                touchStarted=true;
                txtSpeed.setText("0");
                countDownTimer.cancel();
                txtTimer.setTextColor(Color.BLACK);
                txtSpeed.setVisibility(View.VISIBLE);
                txtSpeedFinal.setVisibility(View.INVISIBLE);
                return true;
            }
        });

    }

    private void initViews() {
        txtSpeed=findViewById(R.id.txtSpeed);
       // txtTotalTouchRegistered=findViewById(R.id.txtTotalTouchRegistered);
        parent=findViewById(R.id.parent);
        txtTimer=findViewById(R.id.txtTimer);
        imageTimer=findViewById(R.id.imageTimer);
        imageTimerCompleted=findViewById(R.id.imageTimerCompleted);
        txtFinalSpeed=findViewById(R.id.txtFinalSpeed);
        btnInfo=findViewById(R.id.btnInfo);
        txtSpeedFinal=findViewById(R.id.txtSpeedFinal);
    }
    public void fullMethod() {

        initViews();
        if (touchStarted){
            countDownTimer= new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long l) {

                    txtTimer.setText(String.valueOf(l/1000));
                    imageTimer.setVisibility(View.VISIBLE);
                    imageTimerCompleted.setVisibility(View.GONE);
                    txtSpeed.setVisibility(View.VISIBLE);
                    txtSpeedFinal.setVisibility(View.INVISIBLE);



                }

                @Override
                public void onFinish() {
                    parent.setClickable(false);
                    imageTimer.setVisibility(View.INVISIBLE);
                    imageTimerCompleted.setVisibility(View.VISIBLE);
                    txtTimer.setTextColor(Color.RED);
                    float c=(float)taps/10;
                    txtFinalSpeed.setText(c + " Taps/sec");
                    txtSpeed.setVisibility(View.INVISIBLE);
                    txtSpeedFinal.setVisibility(View.VISIBLE);
                    txtSpeedFinal.setText(String.valueOf(taps));

                    //txtTotalTouchRegistered.setText(String.valueOf(taps));


                }
            }.start();
            touchStarted=false;
        }
        taps=taps+1;
//                float speed=taps/(l/1000);
        txtSpeed.setText(String.valueOf(taps));

//                txtSpeed.setText(String.valueOf(speed));
    }

}