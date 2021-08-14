package com.example.dialoglogina1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) vi.inflate(R.layout.login_layout, null);

        //layout.findViewById
        //layout에서 아이디를 찾음
        //그냥 findViewById하면 안됨
        final EditText edit_id = (EditText) layout.findViewById(R.id.edit_id);
        final EditText edit_pw = (EditText) layout.findViewById(R.id.edit_pw);

        if(v == login){ //로그인 버튼 눌렀을 때 다이얼로그 띄우기

            new AlertDialog.Builder(this).setTitle(R.string.loginString)
                    .setView(layout)
                    .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "ID : " + edit_id.getText().toString() + "\npw : "
                            + edit_pw.getText().toString(), Toast.LENGTH_LONG).show();
                        }
                    }).show();
        }
    }
}
