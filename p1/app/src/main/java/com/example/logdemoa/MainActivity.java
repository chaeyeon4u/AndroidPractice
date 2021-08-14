package com.example.logdemoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log 추가
        Log.e("tag", "error message");
        Log.w("tag", "warning message");
        Log.i("tag", "information message");
        Log.d("tag", "debugging message");
        Log.v("tag", "verbose message");
    }
}
