package com.example.myapplication.Task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;

public class activity1 extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4, editText5;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        editText1 = findViewById(R.id.edittxt1);
        editText2 = findViewById(R.id.edittxt2);
        editText3 = findViewById(R.id.edittxt3);
        editText4 = findViewById(R.id.edittxt4);
        editText5 = findViewById(R.id.edittxt5);

        sharedPreferences = getSharedPreferences("task1", 0);

        editText1.setText(sharedPreferences.getString("text1", ""));
        editText2.setText(sharedPreferences.getString("text2", ""));
        editText3.setText(sharedPreferences.getString("text3", ""));
        editText4.setText(sharedPreferences.getString("text4", ""));
        editText5.setText(sharedPreferences.getString("text5", ""));
    }

    public void Show(View view) {
        String text1 = editText1.getText().toString();
        String text2 = editText2.getText().toString();
        String text3 = editText3.getText().toString();
        String text4 = editText4.getText().toString();
        String text5 = editText5.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("text1", text1);
        editor.putString("text2", text2);
        editor.putString("text3", text3);
        editor.putString("text4", text4);
        editor.putString("text5", text5);
        editor.apply();

        Intent intent = new Intent(this, activity2.class);
        startActivity(intent);
    }
}