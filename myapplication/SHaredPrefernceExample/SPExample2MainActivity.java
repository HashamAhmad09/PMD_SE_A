package com.example.myapplication.SHaredPrefernceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class SPExample2MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spexample2_main);
    }
    public void SavePref(View view)
    {
        SharedPreferences preferences=getSharedPreferences("MyFile3",0);
        SharedPreferences.Editor editor =preferences.edit();
        editor.putString("Iphone","Iphone 11");
        editor.putString("Nokia","nokia 10");
        editor.putString("Samsung","Note 12");
        editor.putString("Oppo","Y11");
        editor.putString("Techno","Camon 15");
        editor.putString("Infinix","S11");
        editor.putString("Google","Pixel 4a");
        editor.commit();
        if(preferences.contains("Oppo")&& preferences.contains("Iphone"))
        {
            Intent intent = new Intent(this, SpExampleTwoSecondAcitivity.class);
            startActivity(intent);
        }

    }
}