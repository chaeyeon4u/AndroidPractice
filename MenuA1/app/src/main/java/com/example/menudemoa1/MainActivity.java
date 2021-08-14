package com.example.menudemoa1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.menu1){
            Toast.makeText(this, R.string.menu1, Toast.LENGTH_SHORT).show();
            return true;
        }else if(id == R.id.menu2){
            Toast.makeText(this, R.string.menu2, Toast.LENGTH_SHORT).show();
            return true;
        }else if(id == R.id.menu3){
            Toast.makeText(this, R.string.menu3, Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
