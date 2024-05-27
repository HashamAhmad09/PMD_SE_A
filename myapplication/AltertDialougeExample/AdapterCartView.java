package com.example.myapplication.AltertDialougeExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

import java.util.List;

public class AdapterCartView extends RecyclerView.Adapter<AdapterCartView.MyCartViewHolder>{
    public Context context;
    List<My_Model> list;

    public AdapterCartView( Context context, List<My_Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card,parent,false);
     return new MyCartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartViewHolder holder, int position) {
     My_Model myModel=list.get(position);
     holder.title.setText(myModel.getName());
     holder.count.setText(String.valueOf(myModel.getTotal_Downloads()));
     Glide.with(context).load(myModel.getThumbnails()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyCartViewHolder extends RecyclerView.ViewHolder{
      TextView title,count;
      ImageView imageView;
        public MyCartViewHolder(@NonNull View itemView) {
            super(itemView);
           // imageView=itemView.findViewById(R.id.imgcardview);
            title=itemView.findViewById(R.id.txtcard1);
            count=itemView.findViewById(R.id.txtcard2);
        }
    }
}
