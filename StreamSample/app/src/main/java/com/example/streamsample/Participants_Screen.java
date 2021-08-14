package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Participants_Screen extends AppCompatActivity {

    LinearLayout Participant_Screen_Participants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_participants__screen);

        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Participant_Screen_Participants=(LinearLayout)findViewById(R.id.Participant_Screen_Participants);
        Participant_Screen_Participants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Participants_Screen_Menu.class);
                startActivity(i);
                finish();
            }
        });
    }
}
