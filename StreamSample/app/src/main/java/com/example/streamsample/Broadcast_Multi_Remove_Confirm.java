package com.example.streamsample;

import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Broadcast_Multi_Remove_Confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_broadcast__multi__remove__confirm);

        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

    }
}
