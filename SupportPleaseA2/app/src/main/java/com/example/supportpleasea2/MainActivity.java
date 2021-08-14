package com.example.supportpleasea2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notif = (Button) findViewById(R.id.notif);
        notif.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //통지하기
            /* 핸드폰번호를 다이얼에 띄울 Intent를 지정한다.
             * intent는 메시지를 전달해주는 역할을 한다. */
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01051234443"));

            /* 직역하면 지연된메시지라는 뜻으로 메시지 전달을 바로하지 않고 개발자가 원할 때 하도록 잠시 미룬다.
             * FLAG_CANCEL_CURRENT는 이전에 실행되는 PendingIntent가 있다면 취소하고 현재의 Pendingintent를 다시 시작하라. */
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

            /* NotificationCompat.Builder는 Notification의 통지형식을 잡아주는 역할을 한다. */
            Notification notification = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("My First Notification")
                    .setContentText("Notification contents")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)    //setAutoCancel은 사용자가 Notification 클릭했을 때 사라지는 옵션이다.
                    .build();

            /* NotificationManager는 system에 notification을 통지하는 역할을 한다. */
            NotificationManager n_manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            n_manager.notify(0, notification);

    }

}