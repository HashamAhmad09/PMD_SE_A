package com.example.myapplication.SQLiteExample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.HashMap;

public class NewContactEntry extends AppCompatActivity {

    EditText firstName,secondName,phoneNumber,emailAddress,homeAddress;
    Button button;
    DbTools dbTools;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_contact_entry);
        firstName = findViewById(R.id.edtfirstname);
        secondName = findViewById(R.id.edtsecondname);
        phoneNumber = findViewById(R.id.edtphonenumber);
        emailAddress = findViewById(R.id.edtemail);
        homeAddress = findViewById(R.id.edthomeaddress);
        button = findViewById(R.id.btnsave);
        dbTools=new DbTools(getApplicationContext());
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                HashMap<String,String>contact = new HashMap<String,String>();
                contact.put("firstName",firstName.getText().toString());
                contact.put("secondName",secondName.getText().toString());
                contact.put("phoneNumber",phoneNumber.getText().toString());
                contact.put("emailAddress",emailAddress.getText().toString());
                contact.put("homeAddress",homeAddress.getText().toString());
                AlertDialog.Builder builder= new AlertDialog.Builder(NewContactEntry.this);
                builder.setMessage("Save in DB").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbTools.AddContact(contact);
                    }
                }).setNegativeButton("NO",null);
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });
    }
}