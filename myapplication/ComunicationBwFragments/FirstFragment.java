package com.example.myapplication.ComunicationBwFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class FirstFragment extends Fragment {
    ButtonPressListener.onButtonPressListenter buttonPressListenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.firstfragment, container, false);
        myFunction(root);
        return root;
    }
    void myFunction(ViewGroup root)
    {
        TextView textView= root.findViewById(R.id.txtcmfragemnt);
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
             //textView.setText("Message aye hai First Fragment sae....");
             buttonPressListenter.onButtonPressed("Message aye hai First Fragment sae....");
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPressListenter = (ButtonPressListener.onButtonPressListenter) getActivity();

    }
}
