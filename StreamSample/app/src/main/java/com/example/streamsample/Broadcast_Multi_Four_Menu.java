package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Broadcast_Multi_Four_Menu extends AppCompatActivity {
LinearLayout multi_four_menuoff,multi_four_controls,multi_four_one,multi_four_invite;
            ImageButton multi_four_stopbro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_broadcast__multi__four__menu);

        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        multi_four_stopbro=(ImageButton)findViewById(R.id.multi_four_stopbro);
        multi_four_menuoff=(LinearLayout) findViewById(R.id.multi_four_menuoff);
        multi_four_controls=(LinearLayout)findViewById(R.id.multi_four_controls);
        multi_four_one=(LinearLayout)findViewById(R.id.multi_four_one);
        multi_four_invite=(LinearLayout)findViewById(R.id.multi_four_invite);


        multi_four_stopbro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Hang_Up_Confirm.class);
                startActivity(i);
            }
        });

        multi_four_menuoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
        multi_four_controls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Multi_ControlMenu.class);
                startActivity(i);


            }
        });
        multi_four_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Full_Screen.class);
                startActivity(i);
                finish();

            }
        });

        multi_four_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
