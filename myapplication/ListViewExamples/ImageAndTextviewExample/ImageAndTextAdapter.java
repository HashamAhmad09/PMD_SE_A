package com.example.myapplication.ListViewExamples.ImageAndTextviewExample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;

public class ImageAndTextAdapter extends ArrayAdapter<String>
{

    private final Activity activity;
    private final String[]Name;
    private final String[]Text;
    private final Integer[]Image;

    public ImageAndTextAdapter(@NonNull   Activity activity, String[] name, String[] text, Integer[] image) {
        super(activity, R.layout.mylistlayout,name);
        this.activity = activity;
        Name = name;
        Text = text;
        Image = image;
    }
    @NonNull
    public View getView(int position, View view, @NonNull ViewGroup viewGroup)
    {
        LayoutInflater inflater = activity.getLayoutInflater();
        @SuppressLint({"ViewHolder", "InflateParams"})
        View viewholder = inflater.inflate(R.layout.mylistlayout,null);
        TextView textView1 = viewholder.findViewById(R.id.txtandimage1);
        TextView textView2 = viewholder.findViewById(R.id.txtandimage2);
        ImageView imageVIew = viewholder.findViewById(R.id.imgandtext);
        textView1.setText(Name[position]);
        textView2.setText(Text[position]);
        imageVIew.setImageResource(Image[position]);
        return viewholder;
    }

}
