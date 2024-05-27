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

public class Fragment4 extends Fragment {
    public ImageView imageView4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.assignment_fragment4,container,false);
        imageView4=view.findViewById(R.id.afimageView4);
        DownloadImage();
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView4.getVisibility()==view.VISIBLE)
                {
                    imageView4.setVisibility(view.INVISIBLE);
                }
                else {
                    imageView4.setVisibility(view.VISIBLE);
                }
            }
        });
        return view;
    }
    public void DownloadImage()
    {
        ImageDownloadService obj=new ImageDownloadService();
        try {
            Bitmap bitmap=obj.execute("https://www.gettyimages.ca/gi-resources/images/500px/983794168.jpg").get();
            imageView4.setImageBitmap(bitmap);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
