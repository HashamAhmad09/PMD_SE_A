package com.example.myapplication.FragmentExamples;

import android.content.res.Configuration;
import android.os.Bundle;
import android.security.ConfirmationPrompt;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;

public class FragmentExampleOneMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_fragment_example_one_main2);
        Configuration config=getResources().getConfiguration();
        FragmentManager FM =getSupportFragmentManager();
        FragmentTransaction FT=FM.beginTransaction();
        if(config.orientation== Configuration.ORIENTATION_LANDSCAPE)
        {
            LM_Fragment lmFragment=new LM_Fragment();
            FT.replace(android.R.id.content,lmFragment);
        }
        else {
            PM_Fragment pmFragment=new PM_Fragment();
            FT.replace(android.R.id.content,pmFragment);
        }
        FT.commit();

    }
}