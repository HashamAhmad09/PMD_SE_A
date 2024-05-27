package com.example.myapplication.ComunicationBwFragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class CM_ExampleMainActivity extends AppCompatActivity implements ButtonPressListener.onButtonPressListenter{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cm_example_main);

    }

    @Override
    public void onButtonPressed(String message) {
        SecondFragment secondFragment= (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        secondFragment.onFragmentInteraction(message);


    }
}