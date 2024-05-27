package com.example.myapplication.ServiceExamples.BoundServiceExample;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class BoundServiceMainActivity extends AppCompatActivity {

    MyBoundService myBoundServicePlayer;
    public MyBoundService myBoundService;
    public boolean MyBound=false;
    public ServiceConnection myServiceConnection= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundService.MyBinder myBinder=(MyBoundService.MyBinder)service;
            myBoundService=myBinder.getServiceMethod();
            MyBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bound_service_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,MyBoundService.class);
        bindService(intent,myServiceConnection,BIND_AUTO_CREATE);
    }

    public void PlayMusic(View view) {
        if(MyBound==true)
        {
            if(myBoundService.isPlaying())
            {
                myBoundService.Pause();
            }
            else {
                myBoundService.Play();
            }
        }

    }

}