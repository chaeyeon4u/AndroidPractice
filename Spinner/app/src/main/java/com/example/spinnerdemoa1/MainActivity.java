package com.example.spinnerdemoa1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] numbers = {"1", "2", "3", "4", "5"};

        Spinner spinner = (Spinner)findViewById(R.id.spinner1);

        //Spinner에 Adapter로 형식을 맞춰주는 작업
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, numbers);
        spinner.setAdapter(adapter);

        spinner.setSelection(2);
    }
}
