package com.example.myapplication.ListViewExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiColumnListViewMainActivity extends AppCompatActivity {
    ListView listview;
    public ArrayList<HashMap<String,String>>list ;
    public static final String First_Column= "First";
    public static final String Second_Column= "Second";
    public static final String thrid_Column= "Third";
    public static final String fourth_Column= "fourth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_column_list_view_main);
        listview=findViewById(R.id.mylstmulticolumn);
        LoadValues();
        MyListAdapter adapter =new MyListAdapter(list ,this);
        listview.setAdapter(adapter);
    }
    public void LoadValues() {
        list = new ArrayList<>();

        HashMap<String,String> hashmap1 = new HashMap<>();
        hashmap1.put(First_Column, "ALi");
        hashmap1.put(Second_Column, "Abdullah");
        hashmap1.put(thrid_Column, "Abdul Rehman");
        hashmap1.put(fourth_Column, "Mian");
        list.add(hashmap1);

        HashMap<String,String> hashmap2 = new HashMap<>();
        hashmap2.put(First_Column, "ALi");
        hashmap2.put(Second_Column, "Abdullah");
        hashmap2.put(thrid_Column, "Abdul Rehman");
        hashmap2.put(fourth_Column, "Mian");
        list.add(hashmap2);

        HashMap<String,String> hashmap3 = new HashMap<>();
        hashmap3.put(First_Column, "ALi");
        hashmap3.put(Second_Column, "Abdullah");
        hashmap3.put(thrid_Column, "Abdul Rehman");
        hashmap3.put(fourth_Column, "Mian");
        list.add(hashmap3);

        HashMap<String,String> hashmap4 = new HashMap<>();
        hashmap4.put(First_Column, "ALi");
        hashmap4.put(Second_Column, "Abdullah");
        hashmap4.put(thrid_Column, "Abdul Rehman");
        hashmap4.put(fourth_Column, "Mian");
        list.add(hashmap4);
    }

}