package com.example.myapplication.FirebaseExamples;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FIrebaseExample2MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseDatabase database;
    ArrayList<Student> studentArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_firebase_example2_main);
        recyclerView=findViewById(R.id.firebaserecylerView);


        database=FirebaseDatabase.getInstance("https://my-application-b246a-default-rtdb.firebaseio.com/");
        reference=database.getReference("Student");
        studentArrayList=new ArrayList<>();
        LinearLayoutManager  linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        LoadData();



    }
    public void LoadData(){
        reference.addValueEventListener(new ValueEventListener() {

            FirebaseAdapter adapter;
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    Student obj= new Student();
                    obj.setName(dataSnapshot.child("Name").getValue().toString());
                    obj.setUrl(dataSnapshot.child("Picture").getValue().toString());
                    studentArrayList.add(obj);
                }
                adapter=new FirebaseAdapter(studentArrayList,getApplicationContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}