package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Broadcast_Full_Screen_Out_Menu_Off extends AppCompatActivity {
    LinearLayout FullScreen_out_mute_off,FullScreen_out_menu_off,out_cameraorientation_off,out_multione_off,FullScreen_out_invite_off;
    ImageButton FullScreen_out_stopbro_off;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_broadcast__full__screen__out__menu__off);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();

        FullScreen_out_stopbro_off=(ImageButton)findViewById(R.id.FullScreen_out_stopbro_off);
        FullScreen_out_mute_off=(LinearLayout) findViewById(R.id.FullScreen_out_mute_off);
        FullScreen_out_menu_off=(LinearLayout)findViewById(R.id.FullScreen_out_menu_off);
        out_cameraorientation_off=(LinearLayout)findViewById(R.id.out_cameraorientation_off);
        out_multione_off=(LinearLayout)findViewById(R.id.out_multione_off);
        FullScreen_out_invite_off=(LinearLayout)findViewById(R.id.FullScreen_out_invite_off);


        FullScreen_out_stopbro_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Hang_Up_Confirm.class);
                startActivity(i);
            }
        });

        FullScreen_out_mute_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Full_Screen_Out_Menu.class);
                startActivity(i);
                finish();

            }
        });
        FullScreen_out_menu_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
        out_cameraorientation_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Full_Screen.class);
                startActivity(i);
                finish();


            }
        });
        out_multione_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Multi_Four.class);
                startActivity(i);
                finish();

            }
        });

        FullScreen_out_invite_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
