package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    //onCreate
    // hr wo km jo app chalny se phly srf ak dfa zroor chlna wo onCreate func me hoga
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "onCreate func is call");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart func is call");
    }

    // jo crucial data save krna k agr activity b ho jati to same usi state
    // se ay, mtlb jb screen se hat jay
    // is me most imp code likhy and crucial data save krein
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause func is call");
    }

    // hr onStart k st bh chlta but khali chly ga chahy functionality likhi
    // bh hogi, sai wala after onPause chly ga
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume func is call");
    }

    // is k bad onRestart chlta
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop func is call");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy func is call");
    }

    public void Next(View view) {
        // toast is like a notification jese jb wifi connect hota to connected ya online
        // ka message ata neechy phr wo chala jata to usy toast khty
        //Toast.makeText(this, "My first toast", Toast.LENGTH_SHORT).show();
        // same like toast but it is light weight or iski width full screen ki hoti
        // agr Cdrive me memory km ho to shyd toast na chly but ye chly ga
        // Snackbar.make(view, "My First Msg", Snackbar.LENGTH_SHORT).show();

        // to send data against activity
        Intent intent = new Intent(this, secondActivity.class);
        intent.putExtra("A", "First Value");
        intent.putExtra("B", "second Value");

        startActivity(intent);
    }


}