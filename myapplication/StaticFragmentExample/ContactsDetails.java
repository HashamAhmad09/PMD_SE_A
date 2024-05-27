package com.example.myapplication.StaticFragmentExample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class ContactsDetails extends Fragment {
    TextView textView;
    int arrayLenght;
    int currentIndex=-1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contactdetails,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        arrayLenght=MyContactsMainActivity.cotactsArray.length;
        textView=getActivity().findViewById(R.id.contactsdetailtextview);

    }
    public int getShownIndex()
    {
        return currentIndex;
    }
    public void ContactIndex( int currentIndex)
    {
        if(currentIndex<0||currentIndex>=arrayLenght)
        {
            return;
        }
        this.currentIndex=currentIndex;
        textView.setText(MyContactsMainActivity.contactDetails[currentIndex]);

    }
}
