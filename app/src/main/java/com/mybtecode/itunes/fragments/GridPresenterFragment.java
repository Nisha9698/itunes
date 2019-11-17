package com.mybtecode.itunes.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.mybtecode.itunes.Adapter.GridAdapter;
import com.mybtecode.itunes.R;
import com.mybtecode.itunes.ViewModel.DataHolder;
import com.mybtecode.itunes.api.ItunesApi;
import com.mybtecode.itunes.interfaces.ApiInterface;
import com.mybtecode.itunes.models.DataModel;
import com.mybtecode.itunes.models.ResultData;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GridPresenterFragment extends Fragment {
    private GridView gridLayout;
    private ApiInterface apiInterface;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_result, container, false);
        DataHolder viewModel = ViewModelProviders.of((FragmentActivity) Objects.requireNonNull(getContext())).get(DataHolder.class);

        String query = viewModel.getQuery();
        apiInterface = ItunesApi.getClient().create(ApiInterface.class);

        gridLayout = view.findViewById(R.id.grid);
        getData(query);
        return view;
    }

    private void getData(String query) {
        Call<DataModel> call = apiInterface.getSearchTerm(query);

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(@NonNull Call<DataModel> call, @NonNull Response<DataModel> response) {
                DataModel data = response.body();
                assert data != null;
                ArrayList<ResultData> list = data.getResults();
                Toast.makeText(getContext(), "Success", Toast.LENGTH_LONG).show();
                gridLayout.setAdapter(new GridAdapter(list, getContext()));
            }

            @Override
            public void onFailure(@NonNull Call<DataModel> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
