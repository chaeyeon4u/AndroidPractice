package com.example.foregroundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = MyService.class.getSimpleName();
    private Thread mThread;

    private int mCount = 0;

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(mThread == null){
            mThread = new Thread("My Thread"){
                @Override
                public void run(){
                    for(int i=0; i<5; i++){
                        try{
                            mCount++;
                            Thread.sleep(1000);
                        }catch(InterruptedException e){
                            break;
                        }
                        Log.d("My Service", "서비스 동작 중" + mCount);
                    }
                }
            };
            mThread.start();;
        }
        //START_STICKY : 서비스 강제종료 되면 재시작해라 그때 Intent에 null값을 준다
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");

        if(mThread != null){
            mThread.interrupt();
            mThread = null;
            mCount = 0;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
