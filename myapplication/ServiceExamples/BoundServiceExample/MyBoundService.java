package com.example.myapplication.ServiceExamples.BoundServiceExample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class MyBoundService extends Service {
    public Binder mybinder=new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer=MediaPlayer.create(this, R.raw.sample);

    }
    public void Play()
    {
        mediaPlayer.start();
    }
    public void  Pause()
    {
        mediaPlayer.pause();
    }
    public boolean isPlaying()
    {
        return mediaPlayer.isPlaying();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);

    }
    public void Stop(){
        mediaPlayer.stop();
    }

    public MediaPlayer mediaPlayer;

    public MyBoundService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mybinder;
    }



    public class MyBinder extends Binder
    {
         MyBoundService getServiceMethod()
         {
             return MyBoundService.this;
         }
    }
}
