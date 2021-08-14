package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Broadcastors extends AppCompatActivity {
    TextView broadcastnow,invitefriends,broadcastorstext,back;
    LinearLayout website;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_broadcaster);

       // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        broadcastnow=(TextView)findViewById(R.id.broadcastnow);
        invitefriends=(TextView)findViewById(R.id.invitefriends);
        broadcastorstext=(TextView)findViewById(R.id.broadcastors_text);
        back=(Button)findViewById(R.id.back);
        website=(LinearLayout)findViewById(R.id.website2);

        Typeface f=Typeface.createFromAsset(getAssets(),"font/RAVIE.TTF");
        broadcastnow.setTypeface(f);
        invitefriends.setTypeface(f);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Viewer_Screen_2.class);
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
