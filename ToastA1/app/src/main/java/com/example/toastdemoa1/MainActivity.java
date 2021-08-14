package com.example.toastdemoa1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button toastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toastButton = (Button) findViewById(R.id.toastButton);
        toastButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.toastlayout, null);

        Toast toast = Toast.makeText(this, "TOAST♡",Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
