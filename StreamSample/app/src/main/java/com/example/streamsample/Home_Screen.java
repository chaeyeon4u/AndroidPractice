package com.example.streamsample;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home_Screen extends AppCompatActivity {
    TextView quikstreamer,quikstreamer2,publicbro,pubbrodcast,startbro,strbroadcast,footer;
    ImageButton broadcastors,newbroadcast;
    LinearLayout website;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__screen);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();

        quikstreamer=(TextView)findViewById(R.id.quikstreamer);
        quikstreamer2=(TextView)findViewById(R.id.quikstreamer2);
        publicbro=(TextView)findViewById(R.id.pubbrodcast);
        pubbrodcast=(TextView)findViewById(R.id.publicbro);
        startbro=(TextView)findViewById(R.id.startbro);
        strbroadcast=(TextView)findViewById(R.id.strbroadcast);
        footer=(TextView)findViewById(R.id.footer);
        broadcastors=(ImageButton) findViewById(R.id.broadcastors);
        newbroadcast=(ImageButton) findViewById(R.id.newbroadcast);
        website=(LinearLayout)findViewById(R.id.website);



        Typeface f=Typeface.createFromAsset(getAssets(),"font/RAVIE.TTF");
        Typeface f2=Typeface.createFromAsset(getAssets(), "font/Maiandra_GD-Regular.ttf");

        quikstreamer.setTypeface(f);
        quikstreamer2.setTypeface(f);
        footer.setTypeface(f);
        publicbro.setTypeface(f);
        pubbrodcast.setTypeface(f);
        startbro.setTypeface(f);
        strbroadcast.setTypeface(f);


        broadcastors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Viewer_Screen.class);
                startActivity(i);

            }
        });

        newbroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),New_Broadcast.class);
                startActivity(i);

            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Website.class);
                startActivity(i);

            }
        });

    }
//
//    @Override
//    public void onBackPressed() {
//
//
//
//    }
}
