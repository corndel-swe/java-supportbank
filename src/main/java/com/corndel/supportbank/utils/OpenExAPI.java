package com.corndel.supportbank.utils;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.Unirest;

public class OpenExAPI {
  /**
   * Fetches the current exchange rates from the Open Exchange API.
   * 
   * @return a map of currency codes to their exchange rates, or null if the
   *         request fails
   */
  public static Map<String, Double> fetchRates() {
    Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("OPEN_EXCHANGE_API_KEY");
    String url = "https://openexchangerates.org/api/latest.json?symbols=USD,GBP,EUR,JPY,AUD";

    var response = Unirest.get(url)
        .header("Accept", "application/json")
        .header("Authorization", "Token " + apiKey)
        .asString();

    var json = response.getBody();
    var mapper = new ObjectMapper();

    try {
      var data = mapper.readTree(json).get("rates");

      return Map.of(
          "GBP", data.get("GBP").asDouble(),
          "EUR", data.get("EUR").asDouble(),
          "USD", data.get("USD").asDouble(),
          "JPY", data.get("JPY").asDouble(),
          "AUD", data.get("AUD").asDouble());
    } catch (Exception e) {
      System.err.println("Failed to fetch exchange rates from Open Exchange API");
      return null;
    }
  }
}
