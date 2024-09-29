package com.corndel.supportbank.models;

import java.util.Map;
import com.corndel.supportbank.utils.OpenExAPI;

public class Currency {
  private double value;
  private String code;

  public static Map<String, Double> rates = Map.of(
      "USD", 1.0,
      "GBP", 0.8,
      "EUR", 0.9,
      "JPY", 110.0,
      "AUD", 1.5);

  public static Map<String, String> symbols = Map.of(
      "GBP", "£",
      "USD", "$",
      "EUR", "€",
      "JPY", "¥",
      "AUD", "A$");

  /**
   * Fetch the latest currency exchange rates from the Open Exchange Rates API
   * and set them as the rates for this application.
   *
   * This method should be called whenever the user wishes to refresh the
   * currency exchange rates.
   */
  public static void refreshRates() {
    rates = OpenExAPI.fetchRates();
  }

  public Currency(double value, String code) {
    if (!rates.containsKey(code)) {
      throw new IllegalArgumentException("Invalid currency code: " + code);
    }

    this.value = value;
    this.code = code;
  }

  /**
   * Convert the currency to a new currency.
   *
   * @param toCode the currency code to convert to
   *
   * @throws IllegalArgumentException if the currency code is invalid
   */
  public void convert(String toCode) {
    if (code.equals(toCode)) {
      return;
    }

    if (!rates.containsKey(toCode)) {
      throw new IllegalArgumentException("Invalid currency code: " + toCode);
    }

    double rate = rates.get(toCode) / rates.get(code);
    this.value = value * rate;
    this.code = toCode;
  }

  @Override
  public String toString() {
    return String.format("%s%.2f", getSymbol(), value);
  }

  public double getValue() {
    return value;
  }

  public String getCode() {
    return code;
  }

  public String getSymbol() {
    return symbols.get(code);
  }

  public void setValue(double value) {
    this.value = value;
  }
}
