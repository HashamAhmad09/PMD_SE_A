package com.example.myapplication.SQLiteExample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.HashMap;

public class EditContactEntry extends AppCompatActivity {
    DbTools dbTools;
    EditText firstName,secondName,phoneNumber,emailAddress,homeAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_contact_entry);
        dbTools=new DbTools(getApplicationContext());
        Intent intent=getIntent();
        String id = intent.getStringExtra("_id");
        HashMap<String,String>singleContact= dbTools.getSingleContact(id);
        firstName.setText(singleContact.get("firstName"));
        secondName.setText(singleContact.get("secondName"));
        phoneNumber.setText(singleContact.get("phoneNumber"));
        emailAddress.setText(singleContact.get("emailAddress"));
        homeAddress.setText(singleContact.get("homeAddress"));

        Button updateBtn = findViewById(R.id.btnupdate);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> updatedContact = new HashMap<>();
                updatedContact.put("firstName", firstName.getText().toString());
                updatedContact.put("secondName", secondName.getText().toString());
                updatedContact.put("phoneNumber", phoneNumber.getText().toString());
                updatedContact.put("emailAddress", emailAddress.getText().toString());
                updatedContact.put("homeAddress", homeAddress.getText().toString());

                dbTools.editContact(id, updatedContact);
            }
        });

        Button deleteBtn = findViewById(R.id.btndelete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbTools.deleteContact(id);
            }
        });
    }


    }
