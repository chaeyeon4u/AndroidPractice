package com.example.streamsample;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.example.nishant.ouikstreamer.SharedData.SharedPreference;
//import com.example.nishant.ouikstreamer.UserDataUpload.Asctask;
//import com.example.nishant.ouikstreamer.model.Constant;
//import com.example.nishant.ouikstreamer.model.modelformdata;
//import com.example.nishant.ouikstreamer.model.otpdata;
import com.example.streamsample.SharedData.SharedPreference;
import com.example.streamsample.UserDataUpload.Asctask;
import com.example.streamsample.model.Constant;
import com.example.streamsample.model.modelformdata;
import com.example.streamsample.model.otpdata;

public class Otp_Verification extends AppCompatActivity {

    EditText code;
    modelformdata m;
    Activity context;
    Button verify;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp__verification);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        context=this;

        code=(EditText)findViewById(R.id.code);
        verify=(Button)findViewById(R.id.otp_verify);
        text=(TextView)findViewById(R.id.textotp);

        Typeface f = Typeface.createFromAsset(getAssets(), "font/font.otf");

        text.setTypeface(f);

        m=new modelformdata();

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(otpdata.getOtpcode().equals(code.getText().toString()))
                {
                    SharedPreference ss = new SharedPreference();

                    ss.save(context, m.getName(), "Name");
                    ss.save(context, m.getEmail(), "Email");
                    ss.save(context, m.getPh_no(), "Phone");

                    m.setUrl_link("http://telpherpoint.com/quikstreamer/insertuserdata.php");

                    Asctask aa = new Asctask(Otp_Verification.this);
                    aa.setRegistrationForm(m, Constant.FormRegistration);


                }

                else
                {
                    code.setError("Invalid Code");

                }
            }
        });


    }
}
