package com.example.myapplication.ClassActivityFirebase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class DataEntryPage extends AppCompatActivity {

    public EditText edtName,edtCompany,edtPrice;
    ImageView imageView;
    Bitmap bitmap;
    MobileModel model;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_data_entry_page);
       edtName=findViewById(R.id.deeditTextText1);
       edtCompany=findViewById(R.id.deeditTextText2);
       edtPrice=findViewById(R.id.deeditText3);
       imageView=findViewById(R.id.deimageView);
       firebaseDatabase=FirebaseDatabase.getInstance("https://my-application-b246a-default-rtdb.firebaseio.com/");
       databaseReference=firebaseDatabase.getReference("Mobile");
       model=new MobileModel();
    }

    public void SaveintoFireBase(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent,102);
        model.setName(edtName.getText().toString());
        model.setCompany(edtCompany.getText().toString());
        model.setPrice(edtPrice.getText().toString());
        model.setMobileImage(bitmap);
        databaseReference.child(model.getName()).setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(DataEntryPage.this, "Mobile Information has been Saved to Firebase", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DataEntryPage.this, "Mobile Information has not been Saved to Firebase", Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 102  && resultCode==RESULT_OK)
        {
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                if(bitmap != null)
                {
                    bitmap.recycle();
                }
                else
                {
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    imageView.setImageBitmap(bitmap);
                    imageView.setMaxHeight(20);
                    imageView.setMaxWidth(10);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void ShowList(View view) {
    }
}