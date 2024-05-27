package com.example.myapplication.ServiceExamples;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class ServiceExampleOneMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_service_example_one_main);

    }

    public void StartService(View view) {
         Intent intent = new Intent(this, MyServiceExampleOne.class);
        startService(intent);

    }

    public void StopService(View view) {
        Intent intent = new Intent(this, MyServiceExampleOne.class);
        stopService(intent);

    }
}