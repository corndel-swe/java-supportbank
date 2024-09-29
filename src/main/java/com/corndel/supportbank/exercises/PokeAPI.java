package com.corndel.supportbank.exercises;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.Unirest;

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
  public static Pokemon getPokemonByName(String name) throws Exception {
    String url = "https://pokeapi.co/api/v2/pokemon/" + name;

    var response = Unirest.get(url).asString();

    var mapper = new ObjectMapper();
    Pokemon pokemon = mapper.readValue(response.getBody(), Pokemon.class);

    return pokemon;
  }

  /**
   * For debugging purposes..
   */
  public static void main(String[] args) {
    try {
      Pokemon pokemon = getPokemonByName("pikachu");
      System.out.println(pokemon);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
