package com.example.myapplication.FirebaseExamples;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseExapmleOneMainActivity extends AppCompatActivity {
    DatabaseReference myReference;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_firebase_exapmle_one_main);
        textView=findViewById(R.id.txtfirebase);
        FirebaseDatabase database=FirebaseDatabase.
                getInstance("https://myapplication2pmd-default-rtdb.firebaseio.com/");
        myReference= database.getReference();
        // myReference.setValue("This is first value");

    }
    public void ReteriveValue(View view) {
        myReference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                /*String value = snapshot.getValue().toString();
                textView.setText(value);*/
                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                 String value= (String) dataSnapshot.getValue();
                 Log.d("TAG",""+value);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
    }

    public void send(View view) {
        myReference.setValue("THe first value to be reterive");

       // myReference.child("BSSE").child("PMD").child("Student 1").setValue("Ali");
        //myReference.child("BSCS").child("SMD").child("Student 2").setValue("Ahmad");
    }
}