package com.example.proj.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import com.example.proj.model.NewsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class News {
    NewsResponse newsResponse;
    String API_KEY = "fd1e0b30d23b4396be37ae552f54b2a1";
    private String search;
    private ArrayList<String> languages = new ArrayList<String>();
    private ArrayList<String> sorts = new ArrayList<String>();
    private String yourLanguage;
    private String yourSort;

	public News() {
        languages.add("en");
        languages.add("es");
        languages.add("ru");
        sorts.add("relevancy");
        sorts.add("popularity");
        sorts.add("publishedAt");
    }

    public String execute() throws Exception {
        String format = "yyyy-MM-dd";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String currentDate = dateFormat.format(calendar.getTime());

        try {
            URL url = new URL("https://newsapi.org/v2/everything?q=tech&from=" + currentDate + "&language=en&sortBy=publishedAt&apiKey=" + API_KEY);
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
            URL url = new URL("https://newsapi.org/v2/everything?q=" + getSearch() + "&searchIn=title,description&from=" + currentDate + "&language=" + getYourLanguage() + "&sortBy=" + getYourSort() + "&apiKey=" + API_KEY);
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

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public String getYourLanguage() {
        return yourLanguage;
    }

    public void setYourLanguage(String yourLanguage) {
        this.yourLanguage = yourLanguage;
    }
    
    public ArrayList<String> getSorts() {
        return sorts;
    }

    public void setSorts(ArrayList<String> sorts) {
        this.sorts = sorts;
    }

    public String getYourSort() {
        return yourSort;
    }

    public void setYourSort(String yourSort) {
        this.yourSort = yourSort;
    }
}