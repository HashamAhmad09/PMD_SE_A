package com.example.myapplication.Task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class activity2 extends AppCompatActivity {
    ListView listView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        listView = findViewById(R.id.lstview1);

        sharedPreferences = getSharedPreferences("task1", 0);

        ArrayList<String> dataList = new ArrayList<>();
        dataList.add(sharedPreferences.getString("text1", ""));
        dataList.add(sharedPreferences.getString("text2", ""));
        dataList.add(sharedPreferences.getString("text3", ""));
        dataList.add(sharedPreferences.getString("text4", ""));
        dataList.add(sharedPreferences.getString("text5", ""));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

    }
}