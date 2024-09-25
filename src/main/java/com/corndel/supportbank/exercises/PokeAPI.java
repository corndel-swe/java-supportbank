package com.corndel.supportbank.exercises;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class represents a Pokemon. It uses Java's record syntax to
 * automatically generate a class with getters and utility methods.
 * See this url for more info:
 * https://www.baeldung.com/java-record-keyword
 */
@JsonIgnoreProperties(ignoreUnknown = true)
record Pokemon(Integer id, String name, Integer height, Integer weight) {
}

public class PokeAPI {
  /**
   * Get a Pokemon by its name.
   *
   * Makes a GET request to the PokeAPI, and uses Jackson to parse the JSON
   * response into a Pokemon object.
   *
   * @param name The name of the Pokemon to retrieve.
   * @return The Pokemon object.
   */
  public static Pokemon getPokemonByName(String name) throws IOException, InterruptedException {
    // TODO: Make a HttpClient
    HttpClient client = HttpClient.newHttpClient();

    // TODO: Build the HttpRequest
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + name))
        .build();

    // TODO: Send the HttpRequest
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    // TODO: Parse the HttpResponse into a Pokemon object
    // Hint: Use response.body()
    // Hint: Use Jackson's ObjectMapper and the Pokemon class
    String json = response.body();
    ObjectMapper mapper = new ObjectMapper();
    Pokemon pokemon = mapper.readValue(json, Pokemon.class);

    // TODO: Return the Pokemon
    return pokemon;
  }

  /**
   * For debugging purposes..
   */
  public static void main(String[] args) {
    try {
      Pokemon pokemon = getPokemonByName("pikachu");
      System.out.println(pokemon);
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
