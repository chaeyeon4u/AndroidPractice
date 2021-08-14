package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Viewer_Screen2_Menu extends AppCompatActivity {

    TextView ViewerScree2_join;
    ImageButton ViewerScreen2_menuoff,ViewerScreen2_menu_startbro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));
        setContentView(R.layout.activity_viewer__screen2__menu);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        ViewerScreen2_menuoff=(ImageButton)findViewById(R.id.ViewerScreen2_menuoff);
        ViewerScreen2_menu_startbro=(ImageButton)findViewById(R.id.ViewerScreen2_menu_startbro);
        ViewerScree2_join=(TextView) findViewById(R.id.ViewerScree2_join);


        ViewerScreen2_menuoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        ViewerScreen2_menu_startbro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),New_Broadcast.class);
                startActivity(i);
                finish();
            }
        });

        ViewerScree2_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Participants_Screen.class);
                startActivity(i);
                finish();
            }
        });



    }
}
