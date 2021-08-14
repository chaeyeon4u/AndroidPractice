package com.example.prefdemoa1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        /* android.R.id.content 는 안드로이드에 예약되어있는 예약어
         * 화면 전체를 가리킨다. */
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle saveInstanceState) {
            super.onCreate(saveInstanceState);

            addPreferencesFromResource(R.xml.prefs);

            Preference p = findPreference("mobile");
            p.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(){

                @Override
                public boolean onPreferenceClick(Preference arg0) {
                    Uri uri = Uri.parse("http://m.androidside.com");
                    Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(browser);

                    return false;
                }

            });
        }
    }

}
