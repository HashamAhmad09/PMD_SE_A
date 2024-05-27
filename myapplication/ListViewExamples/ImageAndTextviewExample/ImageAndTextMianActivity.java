package com.example.myapplication.ListViewExamples.ImageAndTextviewExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

public class ImageAndTextMianActivity extends AppCompatActivity {
    ListView listview;
    String[]Name={"Ali","Hassan","Virat","Naseem","Kashan"};
    String[]Text={"Message from ALi","Message From Hassan","Message From Virat","Msg from naseem","msg kashan"};
    Integer[]Image={R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,
            R.drawable.icon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_and_text_mian);
        listview= findViewById(R.id.lstimageandtext);
        ImageAndTextAdapter adapter =new ImageAndTextAdapter(this,Name,Text,Image);
        listview.setAdapter(adapter);
    }
}