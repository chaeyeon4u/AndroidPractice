package com.example.streamsample.UserDataUpload;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
//import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

//import com.example.nishant.ouikstreamer.Home_Screen;
//import com.example.nishant.ouikstreamer.Otp_Verification;
//import com.example.nishant.ouikstreamer.R;
//import com.example.nishant.ouikstreamer.SharedData.SharedPreference;
//import com.example.nishant.ouikstreamer.model.Constant;
//import com.example.nishant.ouikstreamer.model.modelformdata;
//import com.example.nishant.ouikstreamer.model.otpdata;
//import androidx.appcompat.app.ActionBar;

import com.example.streamsample.Home_Screen;
import com.example.streamsample.Otp_Verification;
import com.example.streamsample.R;
import com.example.streamsample.SharedData.SharedPreference;
import com.example.streamsample.model.Constant;
import com.example.streamsample.model.modelformdata;
import com.example.streamsample.model.otpdata;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class Asctask
{
    String urllink="";
    InputStream server_data_stream=null;
    ProgressDialog pd;
    String ToastText="";
    String sucess_report_value="";
    ArrayList<NameValuePair> nm;
    int flag=0;
    Context context;

  public  Asctask(Context context)
    {
        this.context=context;
    }

   public class async extends AsyncTask {
       @Override
       protected void onPreExecute() {


           pd = new ProgressDialog(context, R.style.AppCompatAlertDialogStyle);
           pd.setMessage("Loading...");
           pd.setCancelable(false);
           pd.show();
           Window window = pd.getWindow();
           window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

       }

       @Override
       protected Object doInBackground(Object[] params) {

connect_TO_server();
           return null;
       }

       @Override
       protected void onPostExecute(Object o) {


           pd.dismiss();
           if(flag== Constant.FormRegistration) {
               if (getServerRegistrationOutput().equals("0")) {
                   Toast.makeText(context,R.string.alredy, Toast.LENGTH_SHORT).show();
               }

               if (getServerRegistrationOutput().equals("1")) {
                   SharedPreference ss = new SharedPreference();

                   modelformdata model=new modelformdata();
                   ss.save(context, model.getName(), "Name");
                   ss.save(context, model.getEmail(), "Email");
                   ss.save(context, model.getPh_no(), "Phone");

                   Intent i = new Intent(context, Home_Screen.class);
                   context.startActivity(i);
               }

               if(getServerRegistrationOutput().equals("2"))
               {
                   Toast.makeText(context, R.string.alredy, Toast.LENGTH_SHORT).show();
               }
           }

           if(flag==Constant.EmailVerification) {
               if(getEmailOutput().equals("2"))
               {
                   Toast.makeText(context, R.string.alredy, Toast.LENGTH_SHORT).show();
               }

               if (getEmailOutput().equals("0")) {
                   Toast.makeText(context, R.string.email_failed, Toast.LENGTH_SHORT).show();
               }

               if (getEmailOutput().equals("1")) {

                   Intent i=new Intent(context, Otp_Verification.class);
                   context.startActivity(i);
               }
           }

       }


   }



    public void setRegistrationForm(modelformdata model_data,int flag)
    {
        nm=new ArrayList<NameValuePair>();
        this.flag=flag;

        nm.add(new BasicNameValuePair("Name",model_data.getName()));
        nm.add(new BasicNameValuePair("Email",model_data.getEmail()));
        nm.add(new BasicNameValuePair("Phone",model_data.getPh_no()));
        Log.d("datathree",""+model_data.getName()+" "+model_data.getEmail()+" "+model_data.getPh_no());

        urllink=model_data.getUrl_link();
        new async().execute();

    }


    public void sendEmailVerification(modelformdata model_data,int flag)
    {
        nm=new ArrayList<NameValuePair>();
        this.flag=flag;

        nm.add(new BasicNameValuePair("Email",model_data.getEmail()));
        nm.add(new BasicNameValuePair("Code", otpdata.getOtpcode()));
        nm.add(new BasicNameValuePair("Phone", model_data.getPh_no()));

        urllink=model_data.getUrl_link();
        new async().execute();
    }


    public String getServerRegistrationOutput() {
        try {
            int ss;
            while ((ss = server_data_stream.read()) != -1) {
                sucess_report_value = Character.toString((char) ss);

                Log.d("Outputt", sucess_report_value);
            }
        }catch (IOException e){
            Log.d("Exception",e.toString());
        }
        return sucess_report_value;
    }


public String getEmailOutput()
{
    try {
        int ss;
        while ((ss = server_data_stream.read()) != -1) {
            sucess_report_value = Character.toString((char) ss);

            Log.d("Outputt", sucess_report_value);
        }
    }catch (IOException e){
        Log.d("Exception",e.toString());
    }
    return sucess_report_value;
}



    public void connect_TO_server()
    {
        try {

            if (!urllink.equals("")) {

                HttpClient c = new DefaultHttpClient();


                HttpPost p = new HttpPost(urllink);

                p.setEntity(new UrlEncodedFormEntity(nm));
                HttpResponse res = c.execute(p);

                HttpEntity entity = res.getEntity();

                server_data_stream = entity.getContent();

            } else {

                Log.d("UrlLinkError", "Url Link Not Specified");
            }

        } catch (Exception e) {

        }

    }
}
