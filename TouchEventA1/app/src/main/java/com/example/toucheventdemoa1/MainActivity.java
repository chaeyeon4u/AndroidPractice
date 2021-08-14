package com.example.toucheventdemoa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView myView = new MyView(this);
        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Log.d("tag", "OnTouchListenerOnTouch");

                    return false;
                }
                return true;
            }
        });
        setContentView(myView);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Log.d("tag", "Activity.onTouchEvent");

            return false;
        }
        return true;
    }

}



class MyView extends View {
    public MyView(Context context){
        super(context);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Log.d("tag", "MyView.onTouchEvent");

            return false;
        }
        return true;
    }
}