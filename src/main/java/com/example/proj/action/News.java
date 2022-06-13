package com.example.proj.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.example.proj.model.NewsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class News {
    NewsResponse newsResponse;
    String API_KEY = "fd1e0b30d23b4396be37ae552f54b2a1";
    private String search;

    public String execute() throws Exception {
        String format = "yyyy-MM-dd";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String currentDate = dateFormat.format(calendar.getTime());

        try {
            URL url = new URL("https://newsapi.org/v2/everything?q=tesla&from=" + currentDate + "&language=en&sortBy=publishedAt&apiKey=" + API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if(conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed :  HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            while((output = br.readLine()) != null) {
                ObjectMapper mapper = new ObjectMapper();
                newsResponse = mapper.readValue(output, NewsResponse.class);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

    public String search() throws Exception {
        String format = "yyyy-MM-dd";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String currentDate = dateFormat.format(calendar.getTime());

        try {
            URL url = new URL("https://newsapi.org/v2/everything?q=" + search + "&from=" + currentDate + "&language=en&sortBy=publishedAt&apiKey=" + API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if(conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed :  HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            while((output = br.readLine()) != null) {
                ObjectMapper mapper = new ObjectMapper();
                newsResponse = mapper.readValue(output, NewsResponse.class);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

    public NewsResponse getNewsResponse() {
        return newsResponse;
    }

    public void setNewsResponse(NewsResponse newsResponse) {
        this.newsResponse = newsResponse;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
}
