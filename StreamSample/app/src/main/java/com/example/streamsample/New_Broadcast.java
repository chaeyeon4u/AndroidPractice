package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class New_Broadcast extends AppCompatActivity {
TextView readytobroadcast,choose,publictext,privatetext,ortext,ichangemymind;
    ImageButton cancel_bro,Public_bro,Private_bro;
    LinearLayout website;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_new__broadcast);

       // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        readytobroadcast=(TextView)findViewById(R.id.readytobroadcast);
        choose=(TextView)findViewById(R.id.choose);
        publictext=(TextView)findViewById(R.id.publictext);
        privatetext=(TextView)findViewById(R.id.privatetext);
        ortext=(TextView)findViewById(R.id.ortext);
        ichangemymind=(TextView)findViewById(R.id.ichangemymind);
        cancel_bro=(ImageButton)findViewById(R.id.cancel_bro);
        Public_bro=(ImageButton)findViewById(R.id.Public_bro);
        Private_bro=(ImageButton)findViewById(R.id.Private_bro);
        website=(LinearLayout)findViewById(R.id.website3);



        Typeface f=Typeface.createFromAsset(getAssets(),"font/RAVIE.TTF");
        Typeface f2= Typeface.createFromAsset(getAssets(),"font/font.otf");

        readytobroadcast.setTypeface(f);
        choose.setTypeface(f);
        choose.setPaintFlags(choose.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        publictext.setTypeface(f);
        privatetext.setTypeface(f);
        ortext.setTypeface(f);
        ichangemymind.setTypeface(f2);

        cancel_bro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Home_Screen.class);
                startActivity(i);
                finish();
            }
        });


        Public_bro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Full_Screen.class);
                startActivity(i);
                finish();
            }
        });


        Private_bro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Home_Screen.class);
                startActivity(i);
                finish();
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Website.class);
                startActivity(i);
                finish();
            }
        });

    }
}
