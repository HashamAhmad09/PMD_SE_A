package com.example.myapplication.StaticFragmentExample;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class MyContactsMainActivity extends AppCompatActivity implements Contacts.ListSelectionListener{

    public static String[] cotactsArray;
    public static String[] contactDetails;
    public ContactsDetails contactsDetailsfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_contacts_main);
        cotactsArray=getResources().getStringArray(R.array.contacts_array);
        contactDetails=getResources().getStringArray(R.array.details_array);
        contactsDetailsfragment= (ContactsDetails) getSupportFragmentManager().findFragmentById(R.id.contactsDetails);



    }

    @Override
    public void onSelection(int position) {
     if (contactsDetailsfragment.getShownIndex()!=position)
     {
         contactsDetailsfragment.ContactIndex(position);
     }
    }
}