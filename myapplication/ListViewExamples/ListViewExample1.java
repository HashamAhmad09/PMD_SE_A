package com.example.myapplication.ListViewExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;

public class ListViewExample1 extends AppCompatActivity {
    ListView listview;
    String[]Names={"Ali","Ahamd","Naveed","Akram","Nabeel","Sheraz","Asif","Ahamd","Naveed","Akram",
            "Nabeel","Sheraz","Asif","Ahamd","Naveed","Akram","Nabeel","Sheraz","Asif","Ahamd",
            "Naveed","Akram","Nabeel","Sheraz","Asif"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example1);
        listview=findViewById(R.id.mylstone);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,Names);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewExample1.this,position+"is clicked ID"+id,Toast.LENGTH_SHORT).show();
            }
        });

    }
}