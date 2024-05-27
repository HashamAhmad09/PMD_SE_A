package com.example.myapplication.SHaredPrefernceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class SpExampleTwoSecondAcitivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_example_two_second_acitivity);
        listView= findViewById(R.id.lstsharedpreferences);
        SharedPreferences sharedPreferences = getSharedPreferences("MyFile3",0);
        String Oppo=sharedPreferences.getString("oppo","");
        String Nokia=sharedPreferences.getString("nokia", "");
        String Iphone=sharedPreferences.getString("Iphone","");
        String Samsung=sharedPreferences.getString("Samsung","");
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add(Oppo);
        arrayList.add(Iphone);
        arrayList.add(Samsung);
        arrayList.add(Nokia);
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);

    }
}