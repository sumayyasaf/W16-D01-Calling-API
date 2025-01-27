package com.omar;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            getMethod();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getMethod() throws URISyntaxException, IOException, InterruptedException {
//        building my request
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://restcountries.com/v3.1/name/italy"))
                .GET()
                .build();

//        setting up the client
        HttpClient httpClient = HttpClient.newHttpClient();


//        send the request
        HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

//        sout the result of the request
        System.out.println(response.body());

        


    }
}