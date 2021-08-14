package com.example.streamsample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.streamsample.SharedData.SharedPreference;

//import com.example.nishant.ouikstreamer.SharedData.SharedPreference;

public class Splash_Screen extends AppCompatActivity {
    static int flag=1,c=0;
    Thread t,t1;
    String pp;
    TextView quikstreamer,quikstreamer2,loading,mvp,patent;
   Activity context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();

        context=this;
        quikstreamer=(TextView)findViewById(R.id.quikstreamer);
        quikstreamer2=(TextView)findViewById(R.id.quikstreamer2);
        loading=(TextView)findViewById(R.id.loading);
        mvp=(TextView)findViewById(R.id.mvp);
        patent=(TextView)findViewById(R.id.patent);

        Typeface f=Typeface.createFromAsset(getAssets(),"font/RAVIE.TTF");
        Typeface f2=Typeface.createFromAsset(getAssets(), "font/Maiandra_GD-Regular.ttf");

        quikstreamer.setTypeface(f);
        quikstreamer2.setTypeface(f);
        loading.setTypeface(f2);
        mvp.setTypeface(f2);
        patent.setTypeface(f2);

        SharedPreference s=new SharedPreference();
        pp=s.getValue(context,"Phone");
        t1=new Thread()
        {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.interrupt();

                if(pp.equals("")) {

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                    t1.interrupt();
                }
                else {
                    Intent i = new Intent(getApplicationContext(), Home_Screen.class);
                    startActivity(i);
                    finish();
                    t1.interrupt();


                }
            }
        };

        t1.start();

        t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(300);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                              valuechange();

                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();

    }

    public void valuechange()
    {


        if(flag==1)
        {
            loading.setText(R.string.loading1);
        }
        if(flag==2)
        {
            loading.setText(R.string.loading2);
        }

        if(flag==3)
        {
            loading.setText(R.string.loading3);
        }

        flag++;
        if(flag>3)
        {flag=1;}
    }

}
