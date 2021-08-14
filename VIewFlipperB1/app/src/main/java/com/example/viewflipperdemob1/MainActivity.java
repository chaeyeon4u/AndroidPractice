package com.example.viewflipperdemob1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button start;
    Button end;
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start);
        end = (Button)findViewById(R.id.end);
        flipper = (ViewFlipper) findViewById(R.id.flipper);

        start.setOnClickListener(this);
        end.setOnClickListener(this);

        //ViewFlipper의 시간적인 간격 설정 ms(밀리세컨드)
        //플리핑 간격 1초
        flipper.setFlipInterval(100);
        flipper.startFlipping();
    }

    @Override
    public void onClick(View v) {
        if(v == start){
            flipper.startFlipping();
        } else if(v == end){
            flipper.stopFlipping();
        }
    }
}
