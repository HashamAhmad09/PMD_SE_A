package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {

    TextView txtView;
    private Intent intent;
    String firstValue;
    String secondValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // jitni bh chzo ki id he wo R class m jaa kr save ho jati
        txtView = findViewById(R.id.txtIntent1);
        intent = getIntent();
        assert intent != null;
        firstValue = intent.getStringExtra("A");
        secondValue = intent.getStringExtra("B");
        Toast.makeText(this, firstValue, Toast.LENGTH_SHORT).show();


    }



    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String msg1 = intent.getStringExtra("A");
        String msg2 = intent.getStringExtra("B");
        //Toast.makeText(this, msg1 + " " +msg2, Toast.LENGTH_SHORT).show();
        String finalMsg = msg1+" "+msg2;
        txtView.setText(firstValue + " " + secondValue);
    }
}