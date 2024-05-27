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

public class Fragment2 extends Fragment {
    public ImageView imageView2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.assignment_fragment2,container,false);
        imageView2=view.findViewById(R.id.afimageView2);
        DownloadImage();
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView2.getVisibility()==view.VISIBLE)
                {
                    imageView2.setVisibility(view.INVISIBLE);
                }
                else {
                    imageView2.setVisibility(view.VISIBLE);
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
            imageView2.setImageBitmap(bitmap);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
