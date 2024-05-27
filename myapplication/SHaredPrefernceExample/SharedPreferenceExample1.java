package com.example.myapplication.SHaredPrefernceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

public class SharedPreferenceExample1 extends AppCompatActivity {
SharedPreferences sharedPreference;
TextView textView;
EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_example1);
        sharedPreference=getSharedPreferences("MyFile2",0);
        textView=findViewById(R.id.txtsharedpreference);
        editText=findViewById(R.id.edtshredperference);

    }

    public void SaveMySharedPreferences(View view) {
    SharedPreferences.Editor editor =sharedPreference.edit();
    String value = editText.getText().toString();
    editor.putString("KEY",value);
   // editor.putInt("A",100);
    //editor.putString("B","Ali");
    editor.commit();
        Snackbar.make(view,"Saved",Snackbar.LENGTH_SHORT).show();
    }

    public void ShowMySharedPreferences(View view) {
        //int value= sharedPreference.getInt("A",0);
        //String value2=sharedPreference.getString("B","No Value");
        textView.setText(sharedPreference.getString("KEY","No Value"));
    }
}