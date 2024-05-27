package com.example.myapplication.AltertDialougeExample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AlertDialougeMainActivity extends AppCompatActivity {
  Button button;
  TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialouge_main);
        button=findViewById(R.id.btnalertdialouge);
        textView=findViewById(R.id.txtalertdialouge);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialougeMainActivity.this);
             builder.setMessage("Are you sure").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                  textView.setText("202020");
                 }
             })
                     .setNegativeButton("Cancel",null);
             AlertDialog alert = builder.create();
             alert.show();
            }
        });
    }

}