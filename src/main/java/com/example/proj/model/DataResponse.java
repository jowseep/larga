package com.example.proj.model;

import java.util.ArrayList;

public class DataResponse {
    private int count;
    private ArrayList<Data> data;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public ArrayList<Data> getData() {
        return data;
    }
    public void setData(ArrayList<Data> data) {
        this.data = data;
    }
}
