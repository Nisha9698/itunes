package com.mybtecode.itunes.interfaces;

import com.mybtecode.itunes.models.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("search?")
    Call<DataModel> getSearchTerm(@Query("term") String term);
}
