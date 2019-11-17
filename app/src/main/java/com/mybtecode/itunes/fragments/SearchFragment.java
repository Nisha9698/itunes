package com.mybtecode.itunes.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.mybtecode.itunes.R;
import com.mybtecode.itunes.ViewModel.DataHolder;

import java.util.Objects;

public class SearchFragment extends Fragment
{
    private String query;
    private Button searchButton;
    private EditText searchTearm;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_search,container,false);

        searchTearm = view.findViewById(R.id.search_tearm);
        searchButton = view.findViewById(R.id.btn);

        searchClick();

        return view;
    }



    private void searchClick()
    {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {


                query = searchTearm.getText().toString();

                DataHolder viewModel = ViewModelProviders.of((FragmentActivity) Objects.requireNonNull(getContext())).get(DataHolder.class);

                viewModel.setQuery(query);

                GridPresenterFragment gridPresenter = new GridPresenterFragment();
                FragmentManager fragmentManager = getFragmentManager();
                assert fragmentManager != null;
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, gridPresenter).commit();

            }
        });
    }
}
