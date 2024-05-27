package com.example.myapplication.cardviewexample;

import static com.example.myapplication.R.*;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AltertDialougeExample.AdapterCartView;
import com.example.myapplication.AltertDialougeExample.My_Model;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CardViewMainActivity extends AppCompatActivity {
 RecyclerView recyclerView;
 public List<My_Model> list;
 public AdapterCartView adapterCartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(layout.activity_cart_view_main2);
        recyclerView=findViewById(R.id.mycartviewrecylerview);
            list = new ArrayList<>();
            RecyclerView.LayoutManager layoutManager=
                    new GridLayoutManager(this,2);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapterCartView);
            insert();

    }
    public void insert()
    {
        int[] thumbnail=new int[]
                {
                        R.drawable.icon,R.drawable.icon,R.drawable.icon,
                        R.drawable.icon,R.drawable.icon,R.drawable.icon,
                        R.drawable.icon
                };
        My_Model myModel =new My_Model("My FIrst Item",10,thumbnail[0]);
        list.add(myModel);
        myModel=new My_Model("My Second Value",20,thumbnail[1]);
        list.add(myModel);
        myModel=new My_Model("My Second third",230,thumbnail[2]);
        list.add(myModel);
        myModel=new My_Model("My Second forth",320,thumbnail[3]);
        list.add(myModel);
        myModel=new My_Model("My Second fith",520,thumbnail[4]);
        list.add(myModel);
        myModel=new My_Model("My Second 6th",120,thumbnail[5]);
        list.add(myModel);
        myModel=new My_Model("My Second 7th",220,thumbnail[6]);
        list.add(myModel);
    }
}