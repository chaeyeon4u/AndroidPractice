package com.example.streamsample;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.streamsample.UserDataUpload.Asctask;
import com.example.streamsample.model.Constant;
import com.example.streamsample.model.modelformdata;
import com.example.streamsample.model.otpdata;
import com.example.streamsample.otp.GenerateOtp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button register;
    EditText name,email,phone;
    TextView footer,logo;
    String Nameget,Phoneget,Emailget;
    Activity context;

    private static final int MY_PERMISSIONS_REQUEST_ACCOUNTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        context = this;
        register = (Button) findViewById(R.id.register);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        footer = (TextView) findViewById(R.id.footer);
        logo = (TextView) findViewById(R.id.logo);


        Typeface f = Typeface.createFromAsset(getAssets(), "font/font.otf");
        Typeface f1 = Typeface.createFromAsset(getAssets(), "font/RAVIE.TTF");
        name.setTypeface(f);
        phone.setTypeface(f);
        email.setTypeface(f);
        footer.setTypeface(f);
        logo.setTypeface(f);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Nameget = name.getText().toString();
                Emailget = email.getText().toString();

                Phoneget = phone.getText().toString();

                if (Nameget.equals("")) {
                    name.setError("Please Enter Your Name");

                } else if (Phoneget.equals("")) {
                    phone.setError("Please Enter Phone Number");

                } else if(!isValidPhone(Phoneget)) {
                    phone.setError("Phone Number Invalid");
                }
                else if((Phoneget.length()>16)||(Phoneget.length()<10))
                {
                    phone.setError("Phone Number Invalid");
                }
                else if(Nameget.length()>30){
                    name.setError("Name Should Be Less Then 30 Characters");
                }
                else if(!isValidName(Nameget))
                {
                    name.setError("Invalid Name");
                }
                else if(!isValidEmail(Emailget)) {
                    email.setError("Enter a valid Email Address");
                }
                else
                {

                            modelformdata m = new modelformdata();
                            m.setName(Nameget);
                            m.setPh_no(Phoneget);
                            m.setEmail(Emailget);
                            String otp = GenerateOtp.random(6);
                            otpdata d = new otpdata();
                            d.setOtpcode(otp);

                            m.setUrl_link("http://telpherpoint.com/quikstreamer/verificationCode.php");

                            Asctask aa = new Asctask(MainActivity.this);

                            aa.sendEmailVerification(m, Constant.EmailVerification);

                }

            }

        });

    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public final static boolean isValidPhone(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return Patterns.PHONE.matcher(target).matches();
        }
    }

    public static boolean isValidName(String txt) {

        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();

    }

}
