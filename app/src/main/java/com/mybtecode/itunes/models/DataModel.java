package com.mybtecode.itunes.models;

import java.util.ArrayList;

public class DataModel {

    private int resultCount;
    private ArrayList<ResultData> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public ArrayList<ResultData> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultData> results) {
        this.results = results;
    }

}
