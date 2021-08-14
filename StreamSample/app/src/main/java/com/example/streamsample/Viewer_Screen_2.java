package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Viewer_Screen_2 extends AppCompatActivity {
LinearLayout part1_fun,part2_fun,part3_fun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_viewer__screen_2);

        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        part1_fun=(LinearLayout)findViewById(R.id.part1_fun);
        part2_fun=(LinearLayout)findViewById(R.id.part2_fun);
        part3_fun=(LinearLayout)findViewById(R.id.part3_fun);

        part1_fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Broadcastors.class);
                startActivity(i);

            }
        });

        part2_fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Viewer_Screen2_Menu.class);
                startActivity(i);


            }
        });

        part3_fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();


            }
        });


    }
}
