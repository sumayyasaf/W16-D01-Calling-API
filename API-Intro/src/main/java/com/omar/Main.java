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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Here is all the students, which information do you want: ");
            System.out.println(getAllStudents());
            System.out.println("Which student would you like to fetch. Give the id");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.nextLine();
//            getMethod();
            getStudentName(id);
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

//    Exercise 1: from the omar class API, fetch the object that represents you
//                display the name as a java String

    public static void getStudentName(String id) throws URISyntaxException, IOException, InterruptedException {
//        build the request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(String.format("https://omar-dci-class.onrender.com/students/%s",id)))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());


        Gson gson = new Gson();
        String studentname = gson.fromJson(response.body(),JsonObject.class).get("studentName").getAsString() ;

        System.out.printf("Student name fetched is: %s",studentname);



    }

    public static JsonArray getAllStudents() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://omar-dci-class.onrender.com/students"))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());


        Gson gson = new Gson();

        return gson.fromJson(response.body(),JsonArray.class);
    }
}