package com.example.streamsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.streamsample.SharedData.SharedPreference;

//import com.example.nishant.ouikstreamer.SharedData.SharedPreference;

public class FirstNoDataActivity extends AppCompatActivity {

    Activity context;
    String pp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_no_data);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        context=this;
        SharedPreference s=new SharedPreference();
        pp=s.getValue(context,"Phone");
        if(pp.equals("")) {

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        }
        else {
            Intent i = new Intent(getApplicationContext(), Home_Screen.class);
            startActivity(i);
            finish();


        }




    }


}
