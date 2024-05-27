package com.example.myapplication.IntentActions;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class imgPicker extends AppCompatActivity {
    ImageView imageView;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_picker);
        imageView=findViewById(R.id.imgpicker);
    }

    public void OpenGallery(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent,102);
        imageView.setImageResource(R.drawable.img4);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==102&& resultCode==RESULT_OK)
        {
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                if(bitmap !=null)
                {
                    bitmap.recycle();
                }
                bitmap= BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            }catch (FileNotFoundException e){
                throw new RuntimeException(e);
            }
        }
    }
}