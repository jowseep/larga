package com.example.proj.model;

import java.util.ArrayList;

public class NewsResponse {
    private String status;
    private String totalResults;
    private ArrayList<Articles> articles;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }
    public ArrayList<Articles> getArticles() {
        return articles;
    }
    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }    
}
