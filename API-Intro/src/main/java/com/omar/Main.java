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
                .uri(new URI("https://swapi.dev/api/people/4"))
                .GET()
                .build();

//        setting up the client
        HttpClient httpClient = HttpClient.newHttpClient();


//        send the request
        HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

//        sout the result of the request
        System.out.println(response.body().getClass());


        Gson gson = new Gson();

//        converts my string into a json object
        JsonObject convertedResponseToJSON = gson.fromJson(response.body(),JsonObject.class);

        System.out.println(convertedResponseToJSON);

        String characterName = convertedResponseToJSON.get("name").getAsString();
        int height = convertedResponseToJSON.get("height").getAsInt();

        System.out.println(characterName.toUpperCase());
        System.out.printf("character name is %s and character height is %dcm",characterName,height);
    }

    
}