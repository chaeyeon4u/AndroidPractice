package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Participants_Screen_Menu extends AppCompatActivity {

    ImageButton Participants_Screen_menuoff,Participants_Screen_leave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_participants__screen__menu);

        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Participants_Screen_menuoff=(ImageButton)findViewById(R.id.Participants_Screen_menuoff);
        Participants_Screen_leave=(ImageButton)findViewById(R.id.Participants_Screen_leave);

        Participants_Screen_menuoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Participants_Screen.class);
                startActivity(i);
                finish();

            }
        });

        Participants_Screen_leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Viewer_Screen.class);
                startActivity(i);
                finish();

            }
        });
    }
}
