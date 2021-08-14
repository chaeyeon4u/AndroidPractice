package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Viewer_Screen extends AppCompatActivity {


    FrameLayout mainbroadcasterframe,participantframe,participantframe4;
    LinearLayout website;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_viewer__screen);

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        mainbroadcasterframe=(FrameLayout)findViewById(R.id.mainbroadcasterFrame);
        mainbroadcasterframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        participantframe=(FrameLayout)findViewById(R.id.participantframe);
        participantframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Viewer_Screens_menu.class);
                startActivity(i);

            }
        });


        participantframe4=(FrameLayout)findViewById(R.id.participantframe4);
        participantframe4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Viewer_Screen_2.class);
                startActivity(i);

            }
        });

        website=(LinearLayout)findViewById(R.id.website4);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Website.class);
                startActivity(i);

            }
        });
    }
}
