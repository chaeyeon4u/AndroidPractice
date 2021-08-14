package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements FragmentCallBack{
    Fragment1 fragment1;
    Fragment2 fragment2;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        fragment1 = (Fragment1) manager.findFragmentById(R.id.fragment1);
        fragment2 = (Fragment2) manager.findFragmentById(R.id.fragment2);
    }

    public void ImageChanged(int index){
        fragment2.setImage(index);
    }

}
