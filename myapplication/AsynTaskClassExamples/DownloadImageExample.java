package com.example.myapplication.AsynTaskClassExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class DownloadImageExample extends AppCompatActivity
{
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_image_example);
        imageView=findViewById(R.id.imgasync);

    }
    class ImageDownload extends AsyncTask<String,Void, Bitmap>
    {

        @Override
        protected Bitmap doInBackground(String... strings)
        {
            URL url=null;
            try
            {
                url=new URL(strings[0]);
                HttpsURLConnection connection= (HttpsURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream=connection.getInputStream();
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                return bitmap;

            } catch (MalformedURLException e)
            {
                throw new RuntimeException(e);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public void DownloadImage(View view) {
     ImageDownload obj=new ImageDownload();
        try {
            Bitmap bitmap=obj.execute("https://th.bing.com/th/id/R.24b5d1e9022871280ce78314dd4ffe2d?rik=qOqHdOmxu94phA&pid=ImgRaw&r=0").get();
            imageView.setImageBitmap(bitmap);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}