package com.example.alterdialogdemoa2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button item;
    Button single;
    Button multi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = (Button) findViewById(R.id.item);
        single = (Button) findViewById(R.id.single);
        multi = (Button) findViewById(R.id.multi);

        item.setOnClickListener(this);
        single.setOnClickListener(this);
        multi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final String[] cars = {"SM3", "SM5", "SM7", "SONATA", "AVANTE"};

        if(v == item){//setItems를 이용하여 다이얼로그에 리스트 생성
            new AlertDialog.Builder(this).setTitle("Choose One")
                    .setItems(cars, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this ,"cars:"+cars[which], Toast.LENGTH_SHORT).show();
                        }
                    }).setNeutralButton("닫기", null).show();
        }
        else if(v == single){//다이얼로그에 SingleChoiceItems 설정함으로써 라디오버튼 생성(하나만 선택 가능)
            new AlertDialog.Builder(this).setTitle("Choose One")
                    .setSingleChoiceItems(cars, -1 ,new DialogInterface.OnClickListener() { // checkedItem 이 -1이면 기본 선택 안한것
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this ,"cars:"+cars[which], Toast.LENGTH_SHORT).show();
                        }
                    }).setNeutralButton("닫기", null).show();
        }
        else if(v == multi){//다이얼로그에 MultiChoiceItems을 설정함으로써 체크박스 생성(여러개 생성 가능)
            new AlertDialog.Builder(this).setTitle("Choose One")
                    .setMultiChoiceItems(cars, null, new DialogInterface.OnMultiChoiceClickListener() { //checkedItems가 null 이면 기본 선택 안한것
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            Toast.makeText(MainActivity.this ,"cars:"+cars[which], Toast.LENGTH_SHORT).show();
                        }
                    }).setNeutralButton("닫기", null).show();
        }

    }
}
