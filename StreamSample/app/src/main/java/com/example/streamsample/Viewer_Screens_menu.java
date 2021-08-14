package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Viewer_Screens_menu extends AppCompatActivity {
ImageButton menuoff,Viewer_menu_startbro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_viewer__screens_menu);

      //  getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        menuoff=(ImageButton)findViewById(R.id.menuoff);
        menuoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        Viewer_menu_startbro=(ImageButton)findViewById(R.id.Viewer_menu_startbro);
        Viewer_menu_startbro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),New_Broadcast.class);
                startActivity(i);

            }
        });

    }
}
