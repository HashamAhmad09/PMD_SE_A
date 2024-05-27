package com.example.myapplication.RecylerViewExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class AdapterRecylerView extends RecyclerView.Adapter<AdapterRecylerView.ViewHolder>
{

    private List<MyMobile> mobileList;

    public AdapterRecylerView(List<MyMobile> mobileList) {
        this.mobileList = mobileList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mobilerowexample,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     MyMobile myMobile=mobileList.get(position);
     holder.Mobilename.setText(myMobile.getName());
     holder.MobileCompany.setText(myMobile.getCompany());
     holder.Mobileprice.setText(myMobile.getPrice());

    }

    @Override
    public int getItemCount() {
        return mobileList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView Mobilename,MobileCompany,Mobileprice;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            Mobilename=itemView.findViewById(R.id.txtmobilename);
            MobileCompany=itemView.findViewById(R.id.txtmobilecompany);
            Mobileprice=itemView.findViewById(R.id.txtmobileprice);
        }
    }
}
