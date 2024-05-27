 package com.example.myapplication.RecylerViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecylerViewMainActivity extends AppCompatActivity {
    AdapterRecylerView adapter;
    private RecyclerView recylerView;
    List<MyMobile> mobileList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view_main);
        recylerView=findViewById(R.id.myrecylerview);
         adapter=new AdapterRecylerView((mobileList));
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recylerView.setLayoutManager(layoutManager);
        recylerView.setItemAnimator(new DefaultItemAnimator());
        recylerView.setAdapter(adapter);
        addMobiles();


    }
    public void addMobiles() {
        MyMobile myMobileobj = new MyMobile("Iphone12", "Apple", "400000");
        mobileList.add(myMobileobj);

        myMobileobj = new MyMobile("Iphone13", "Apple", "50000");
        mobileList.add(myMobileobj);

        myMobileobj = new MyMobile("V21e", "vivo", "50000");
        mobileList.add(myMobileobj);

        myMobileobj = new MyMobile("Y12", "oppo", "50000");
        mobileList.add(myMobileobj);

        myMobileobj = new MyMobile("S4", "Infinix", "50000");
        mobileList.add(myMobileobj);

        myMobileobj = new MyMobile("Pixel9a", "Google", "90000");
        mobileList.add(myMobileobj);

        adapter.notifyDataSetChanged();
    }

}