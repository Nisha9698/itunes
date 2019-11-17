package com.mybtecode.itunes.ViewModel;

import androidx.lifecycle.ViewModel;

public class DataHolder extends ViewModel
{
    private String query;

    public void setQuery(String query)
    {
        this.query = query;
    }
    public  String getQuery()
    {
        return query;
    }
}
