package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Broadcast_Full_Screen_Menu extends AppCompatActivity {
LinearLayout FullScreen_mute,FullScreen_menuoff,cameraorientation,multione,FullScreen_invite;
    ImageButton FullScreen_stopbro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_broadcast__full__screen__menu);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();

        FullScreen_stopbro=(ImageButton)findViewById(R.id.FullScreen_stopbro);
        FullScreen_mute=(LinearLayout) findViewById(R.id.FullScreen_mute);
        FullScreen_menuoff=(LinearLayout)findViewById(R.id.FullScreen_menuoff);
        cameraorientation=(LinearLayout)findViewById(R.id.cameraorientation);
        multione=(LinearLayout)findViewById(R.id.multione);
        FullScreen_invite=(LinearLayout)findViewById(R.id.FullScreen_invite);


        FullScreen_stopbro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Hang_Up_Confirm.class);
                        startActivity(i);
            }
        });

        FullScreen_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Full_Screen_Menu_off.class);
                startActivity(i);
                finish();

            }
        });
        FullScreen_menuoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
        cameraorientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Full_Screen_out.class);
                startActivity(i);
                finish();


            }
        });
        multione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Multi_Four.class);
                startActivity(i);
                finish();

            }
        });

        FullScreen_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
