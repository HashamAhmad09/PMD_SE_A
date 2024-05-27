package com.example.myapplication.StaticFragmentExample;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.myapplication.R;

public class Contacts extends ListFragment
{
    public ListSelectionListener mlister=null;
    public interface ListSelectionListener{
        public void onSelection(int position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mlister = (ListSelectionListener) getActivity();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.contacttextview,MyContactsMainActivity.cotactsArray));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
       getListView().setItemChecked(position,true);
       mlister.onSelection(position);
    }
}
