package com.example.proj.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.proj.model.DataResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Weather {
    DataResponse dataResponse = new DataResponse();
    String API_KEY = "10495b97d078417fb38c4183f7f771ad";
    private String city;
    
    public String execute() throws Exception {
        try {
            System.out.println(city);
            URL url = new URL("https://api.weatherbit.io/v2.0/current?city=" + getCity() + "&key=" + API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if(conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed :  HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            while((output = br.readLine()) != null) {
                ObjectMapper mapper = new ObjectMapper();
                dataResponse = mapper.readValue(output, DataResponse.class);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dataResponse.getData());
        return "success";
    }

    public DataResponse getDataResponse() {
        return dataResponse;
    }

    public void setDataResponse(DataResponse dataResponse) {
        this.dataResponse = dataResponse;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }    
}
