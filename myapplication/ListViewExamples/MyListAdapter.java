package com.example.myapplication.ListViewExamples;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MyListAdapter extends BaseAdapter
{
    public ArrayList<HashMap<String,String>> list ;
    Activity activity;
    public static final String First_Column= "First";
    public static final String Second_Column= "Second";
    public static final String thrid_Column= "Third";
    public static final String fourth_Column= "fourth";



    public MyListAdapter(ArrayList<HashMap<String, String>> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewholder= new ViewHolder();
        LayoutInflater inflater=activity.getLayoutInflater();
        if(view== null)
        {
            view = inflater.inflate(R.layout.multicolumn,null);
            viewholder.textview1=view.findViewById(R.id.textView1);
            viewholder.textview2=view.findViewById(R.id.textView2);
            viewholder.textview3=view.findViewById(R.id.textView3);
            viewholder.textview4=view.findViewById(R.id.textView4);
            view.setTag(viewholder);

        }
        else {
            viewholder= (ViewHolder) view.getTag();
        }
        HashMap<String,String> hashmap= list.get(position);
        viewholder.textview1.setText(hashmap.get(First_Column));
        viewholder.textview2.setText(hashmap.get(Second_Column));
        viewholder.textview3.setText(hashmap.get(thrid_Column));
        viewholder.textview4.setText(hashmap.get(fourth_Column));
       return view;
    }
    public static class ViewHolder
    {
        TextView textview1,textview2,textview3,textview4;
    }

}
