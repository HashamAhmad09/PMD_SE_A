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

import com.example.myapplication.AsynTaskClassExamples.DownloadImageExample;
import com.example.myapplication.R;

import java.util.concurrent.ExecutionException;

public class Fragment3 extends Fragment {
    public ImageView imageView3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.assignment_fragment3,container,false);
        imageView3=view.findViewById(R.id.afimageView3);
        DownloadImage();
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView3.getVisibility()==view.VISIBLE)
                {
                    imageView3.setVisibility(view.INVISIBLE);
                }
                else {
                    imageView3.setVisibility(view.VISIBLE);
                }
            }
        });
        return view;
    }
    public void DownloadImage()
    {
        ImageDownloadService obj=new ImageDownloadService();
        try {
            Bitmap bitmap=obj.execute("https://th.bing.com/th/id/R.24b5d1e9022871280ce78314dd4ffe2d?rik=qOqHdOmxu94phA&pid=ImgRaw&r=0").get();
            imageView3.setImageBitmap(bitmap);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
