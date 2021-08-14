package com.example.alertdialogdemoa1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button dialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogButton = (Button) findViewById(R.id.dialogButton);
        dialogButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == dialogButton){
           new AlertDialog.Builder(this)
                   .setIcon(R.drawable.ic_launcher_foreground)
                   .setTitle(R.string.firstString) //resource>values>strings.xml에 string을 추가하여 사용하였다. 기업에서 보통 이렇게 사용
                   .setMessage("Hello")//이렇게 문자열 직접 넣는것 지양. 나중에 회사 들어가서 힘듦
                   .setNeutralButton("close", null)
                   .show();
        }

    }
}
