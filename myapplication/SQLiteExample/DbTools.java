package com.example.myapplication.SQLiteExample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DbTools extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery ="CREATE TABLE CONTACTS("+"_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "firstName TEXT,"+
                "secondName TEXT,"+
                "phoneNumber TEXT,"+
                "emailAddress TEXT,"+
                "homeAddress TEXT)";
        db.execSQL(createQuery);

    }
    public DbTools(Context context){
        super(context,"ContactsDB",null,1);
        Log.d("TAG","Database Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void AddContact(HashMap<String,String> contact)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("_id",contact.get("_id"));
        contentValues.put("firstName",contact.get("firstName"));
        contentValues.put("secondName",contact.get("secondName"));
        contentValues.put("phoneNumber",contact.get("phoneNumber"));
        contentValues.put("emailAddress",contact.get("emailAddress"));
        contentValues.put("homeAddress",contact.get("homeAddress"));
        long i=db.insert("CONTACTS",null,contentValues);
        if(i!=-1)
        {
            Log.d("TAG","New Contact inerted with _id "+i);
        }else {
            Log.d("TAG","New Contact inertion is failed");

        }
        db.close();
    }
    public ArrayList<HashMap<String,String>> getAllContacts()
    {
        SQLiteDatabase db= getReadableDatabase();
        ArrayList<HashMap<String,String>> contactList= new ArrayList<HashMap<String,String>>();
        String Query="SELECT * FROM CONTACTS";
        Cursor cursor= db.rawQuery(Query,null);
        if(cursor.moveToFirst())
        {
         do
          {
             HashMap<String,String> contact=new HashMap<>();
             contact.put("_id",cursor.getString(0));
             contact.put("firstName", cursor.getString(1));
             contact.put("secondName", cursor.getString(2));
             contact.put("phoneNumber", cursor.getString(3));
             contact.put("emailAddress", cursor.getString(4));
             contact.put("homeAddress", cursor.getString(5));
             contactList.add(contact);

          }while (cursor.moveToNext());

        }
        return contactList;

    }

    public HashMap<String, String> getSingleContact(String id) {
        SQLiteDatabase db= getReadableDatabase();
        HashMap<String,String> singleContact =new HashMap<String,String>();
        String Query ="SELECT * FROM CONTACTS WHERE _id="+id;
        Cursor cursor=db.rawQuery(Query,null);
        if(cursor.moveToFirst())
        {
            singleContact.put("_id",cursor.getString(0));
            singleContact.put("firstName",cursor.getString(1));
            singleContact.put("secondName",cursor.getString(2));
            singleContact.put("phoneNumber",cursor.getString(3));
            singleContact.put("emailAddress",cursor.getString(4));
            singleContact.put("homeAddress",cursor.getString(5));
        }
        return singleContact;
    }
    public void editContact(String id, HashMap<String,String> updatedContact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", updatedContact.get("firstName"));
        contentValues.put("secondName", updatedContact.get("secondName"));
        contentValues.put("phoneNumber", updatedContact.get("phoneNumber"));
        contentValues.put("emailAddress", updatedContact.get("emailAddress"));
        contentValues.put("homeAddress", updatedContact.get("homeAddress"));

        int status = db.update("CONTACTS", contentValues, "_id=?", new String[]{id});
        if(status > 0) {
            Log.d("TAG", "Contact updated successfully");
        } else {
            Log.d("TAG", "Failed to update contact");
        }
        db.close();
    }

    public void deleteContact(String id) {
        SQLiteDatabase db = getWritableDatabase();
        int status = db.delete("CONTACTS", "_id=?", new String[]{id});
        if(status > 0) {
            Log.d("TAG", "Contact deleted successfully");
        } else {
            Log.d("TAG", "Failed to delete contact");
        }
        db.close();
    }

}
