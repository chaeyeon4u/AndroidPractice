package com.example.streamsample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Broadcast_Multi_ControlMenu extends AppCompatActivity {
LinearLayout multi_control_remove1,multi_control_remove2,multi_control_remove3,multi_control_menuoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        setContentView(R.layout.activity_broadcast__multi__control_menu);

        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        multi_control_menuoff=(LinearLayout)findViewById(R.id.multi_control_menuoff);
        multi_control_remove1=(LinearLayout) findViewById(R.id.multi_control_remove1);
        multi_control_remove2=(LinearLayout)findViewById(R.id.multi_control_remove2);
        multi_control_remove3=(LinearLayout)findViewById(R.id.multi_control_remove3);

        multi_control_menuoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });

        multi_control_remove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Broadcast_Multi_Remove_Confirm.class);
                startActivity(i);

            }
        });
        multi_control_remove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Multi_Remove_Confirm.class);
                startActivity(i);


            }
        });
        multi_control_remove3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Broadcast_Multi_Remove_Confirm.class);
                startActivity(i);

            }
        });

    }
}
