package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Broadcast_Full_Screen_Out_Menu extends AppCompatActivity {
    LinearLayout FullScreen_out_mute,FullScreen_out_menu,out_cameraorientation,out_multione,FullScreen_out_invite;
    ImageButton FullScreen_out_stopbro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_broadcast__full__screen__out__menu);

        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        FullScreen_out_stopbro=(ImageButton)findViewById(R.id.FullScreen_out_stopbro);
        FullScreen_out_mute=(LinearLayout) findViewById(R.id.FullScreen_out_mute);
        FullScreen_out_menu=(LinearLayout)findViewById(R.id.FullScreen_out_menu);
        out_cameraorientation=(LinearLayout)findViewById(R.id.out_cameraorientation);
        out_multione=(LinearLayout)findViewById(R.id.out_multione);
        FullScreen_out_invite=(LinearLayout)findViewById(R.id.FullScreen_out_invite);


        FullScreen_out_stopbro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Hang_Up_Confirm.class);
                startActivity(i);
            }
        });

        FullScreen_out_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Full_Screen_Out_Menu_Off.class);
                startActivity(i);
                finish();

            }
        });
        FullScreen_out_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
        out_cameraorientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Full_Screen.class);
                startActivity(i);
                finish();


            }
        });
        out_multione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Multi_Four.class);
                startActivity(i);
                finish();

            }
        });

        FullScreen_out_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    }

