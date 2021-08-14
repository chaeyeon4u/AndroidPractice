package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Broadcast_Full_Screen_Menu_off extends AppCompatActivity {
    LinearLayout FullScreen_off_invite,off_multione,off_cameraorientation,FullScreen_off_menuoff,FullScreen_off_mute;
    ImageButton FullScreen_off_stopbro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_broadcast__full__screen__menu_off);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        FullScreen_off_stopbro=(ImageButton)findViewById(R.id.FullScreen_off_stopbro);
        FullScreen_off_mute=(LinearLayout) findViewById(R.id.FullScreen_off_mute);
        FullScreen_off_menuoff=(LinearLayout)findViewById(R.id.FullScreen_off_menuoff);
        off_cameraorientation=(LinearLayout)findViewById(R.id.off_cameraorientation);
        off_multione=(LinearLayout)findViewById(R.id.off_multione);
        FullScreen_off_invite=(LinearLayout)findViewById(R.id.FullScreen_off_invite);


        FullScreen_off_stopbro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Hang_Up_Confirm.class);
                startActivity(i);
            }
        });

        FullScreen_off_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Full_Screen_Menu.class);
                startActivity(i);
                finish();

            }
        });
        FullScreen_off_menuoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
        off_cameraorientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Full_Screen.class);
                startActivity(i);
                finish();


            }
        });
        off_multione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Multi_Four.class);
                startActivity(i);
                finish();

            }
        });

        FullScreen_off_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}
