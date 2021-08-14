package com.example.streamsample.SharedData;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Varun on 10/20/2016.
 */

public class SharedPreference {

    public static final String PREFS_NAME="User";
    public static final String name="Name",email="Email",phone="Phone";


    public void save(Context context,String text,String key){
        SharedPreferences sharedPreference;
        SharedPreferences.Editor editor;

        sharedPreference=context.getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        editor=sharedPreference.edit();

        editor.putString(key,text);
        editor.commit();
    }

    public String getValue(Context context, String key){
      SharedPreferences sharedPreferences;
        String text;

        sharedPreferences=context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        text=sharedPreferences.getString(key,"");

        return text;
    }

    public void clearSharedPreference(Context context){
        SharedPreferences sharedPreference;
        SharedPreferences.Editor editor;

        sharedPreference=context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor=sharedPreference.edit();
        editor.clear();
        editor.commit();
    }

    public void removeValue(Context context,String key){
        SharedPreferences sharedPreference;
        SharedPreferences.Editor editor;

        sharedPreference=context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor=sharedPreference.edit();

        editor.remove(key);
        editor.commit();

    }


}
