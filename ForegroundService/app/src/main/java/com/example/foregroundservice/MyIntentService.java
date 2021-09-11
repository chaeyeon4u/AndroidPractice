package com.example.foregroundservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {

    public MyIntentService(String name) {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        for(int i=0; i<5; i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();//실행중인 Thread를 중단..
            }
            Log.d("MyIntentService", "인텐트 서비스 동작 중"+i);
        }
    }
}
