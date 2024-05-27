package com.example.myapplication.FragmentsAssignment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.util.concurrent.ExecutionException;

public class Fragment1 extends Fragment {
    public ImageView imageView1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.assignment_fragment1,container,false);
        imageView1=view.findViewById(R.id.afimageView1);
        DownloadImage();
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView1.getVisibility()==view.VISIBLE)
                {
                    imageView1.setVisibility(view.INVISIBLE);
                }
                else {
                    imageView1.setVisibility(view.VISIBLE);
                }
            }
        });
        return view;

    }
    public void DownloadImage()
    {
        ImageDownloadService obj=new ImageDownloadService();
        try {
            Bitmap bitmap=obj.execute("https://th.bing.com/th/id/OIP.4CFZ2mAuA-j54uMyutC1EwHaJE?rs=1&pid=ImgDetMain").get();
            imageView1.setImageBitmap(bitmap);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
