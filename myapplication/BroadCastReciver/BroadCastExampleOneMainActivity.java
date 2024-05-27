
package com.example.myapplication.BroadCastReciver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class BroadCastExampleOneMainActivity extends AppCompatActivity {

    AirplaneModeChangeReceiver myBroadCast= new AirplaneModeChangeReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_broad_cast_example_one_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter=new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(myBroadCast,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadCast);
    }
}