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
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a country name: ");
        String country = scanner.nextLine();

        scanner.close();



        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://restcountries.com/v3.1/name/" + country))
                .GET()
                .build();
        //Setting up the client
        HttpClient httpClient = HttpClient.newHttpClient();

        //send the request
        HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        Gson gson = new Gson();
        JsonArray responseArray = gson.fromJson(response.body(), JsonArray.class);



        String name = responseArray.get(0).getAsJsonObject().get("name").getAsJsonObject().get("common").getAsString();
        long population = responseArray.get(0).getAsJsonObject().get("population").getAsLong();
        String continent = responseArray.get(0).getAsJsonObject().get("continents").getAsJsonArray().get(0).getAsString();
        String capital = responseArray.get(0).getAsJsonObject().get("capital").getAsJsonArray().get(0).getAsString();

        System.out.println(name + " is a great country" + "population of " + population + " and is in " + continent + "." + "With the following capital: " + capital + ".\n");




        HttpRequest starWarsgetRequest = HttpRequest.newBuilder()
                .uri(new URI("https://swapi.dev/api/people/4/"))
                .GET()
                .build();
        //Setting up the client
        HttpClient starWarsClient = HttpClient.newHttpClient();

        //send the request
        HttpResponse<String> starWarsresponse = starWarsClient.send(starWarsgetRequest, HttpResponse.BodyHandlers.ofString());



        System.out.println("Sorry we couldn't find your country here is the information for darth vader: " + starWarsresponse.body());

    }
}
