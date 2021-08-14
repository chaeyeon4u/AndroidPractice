package com.example.streamsample.model;

import android.app.Activity;
import android.view.WindowManager;

/**
 * Created by Varun on 10/23/2016.
 */

public class HideComponent {


    public static void setHide(Activity c)
    {
        c.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
