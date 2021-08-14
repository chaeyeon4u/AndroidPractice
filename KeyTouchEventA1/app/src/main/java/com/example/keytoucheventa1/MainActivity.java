package com.example.keytoucheventa1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final : 변하지 않는 값을 설정할 때 사용
        final EditText edit = (EditText) findViewById(R.id.edit);
        final TextView text = (TextView)findViewById(R.id.text);

        Button button = (Button) findViewById(R.id.button);

        //new 이후 익명클래스(인터페이스)
        //익명클래스는 변하지 않는 값을 가지고 실행된다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(edit.getText());
            }
        });
    }
}
