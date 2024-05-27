package com.example.myapplication.ClassActivity2;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.concurrent.ExecutionException;

public class ClassAcitvity2MainActivity extends AppCompatActivity {

    ImageView imageView1,imageView2,imageView3,imageView4;
    AsyncClassActivity asyncClassActivity;
    static Bitmap bitmap1;
    boolean isImageVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_class_acitvity2_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageView1=findViewById(R.id.imageViewca1);
        imageView2=findViewById(R.id.imageViewca2);
        imageView3=findViewById(R.id.imageViewca3);
        imageView4=findViewById(R.id.imageViewca4);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isImageVisible)
                {
                    imageView1.setImageDrawable(null);
                }
                else
                {
                    imageView1.setImageBitmap(bitmap1);
                }
                isImageVisible=!isImageVisible;

            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable =imageView2.getDrawable();
                {
                    if(drawable==null)
                    {
                        imageView2.setImageBitmap(bitmap1);
                    }
                    else
                    {
                        imageView2.setImageDrawable(null);
                    }
                }
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable =imageView3.getDrawable();
                {
                    if(drawable==null)
                    {
                        imageView3.setImageBitmap(bitmap1);
                    }
                    else
                    {
                        imageView3.setImageDrawable(null);
                    }
                }
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable =imageView4.getDrawable();
                {
                    if(drawable==null)
                    {
                        imageView4.setImageBitmap(bitmap1);
                    }
                    else
                    {
                        imageView4.setImageDrawable(null);
                    }
                }
            }
        });

    }


    public void DownloadImages(View view) {
        asyncClassActivity = new AsyncClassActivity();
        try {
            bitmap1 = asyncClassActivity.execute("https://th.bing.com/th/id/OIP.SMbLz0ykY-maystvQsbrRwHaFj?w=235&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7").get();
            imageView1.setImageBitmap(bitmap1);
            imageView2.setImageBitmap(bitmap1);
            imageView3.setImageBitmap(bitmap1);
            imageView4.setImageBitmap(bitmap1);

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}