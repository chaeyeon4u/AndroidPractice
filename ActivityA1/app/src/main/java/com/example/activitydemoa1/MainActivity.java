package com.example.activitydemoa1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("ActivityLife", "onCreate()");

        Button exitButton = (Button)findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        Log.d("ActivityLife", "onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        Log.d("ActivityLife", "onRestoreInstanceState()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("ActivityLife", "onDestroy()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("ActivityLife", "onPause()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("ActivityLife", "onRestart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("ActivityLife", "onResume()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("ActivityLife", "onStart()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("ActivityLife", "onStop()");
    }
}
