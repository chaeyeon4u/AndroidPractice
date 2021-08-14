package com.example.viewflipperdemoa1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

//View.OnClickListener는 추상메소드임(implements 사용)
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button prev;
    Button next;
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prev = (Button) findViewById(R.id.pre);
        next = (Button) findViewById(R.id.next);
        flipper = (ViewFlipper) findViewById(R.id.flipper);

        prev.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == prev){
            flipper.showPrevious();
        }else if(v == next){
            flipper.showNext();
        }
    }
}
