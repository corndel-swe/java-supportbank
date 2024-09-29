package com.corndel.supportbank.models;

import java.util.Map;

public class Currency {
  private double value;
  private String code;
  private String symbol;

  public static Map<String, Double> rates = Map.of(
      "GBP", 1.0,
      "EUR", 1.2,
      "USD", 1.4,
      "JPY", 130.0,
      "AUD", 1.5);

  public static Map<String, String> symbols = Map.of(
      "GBP", "£",
      "EUR", "€",
      "USD", "$",
      "JPY", "¥",
      "AUD", "A$");

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
    this.symbol = symbols.get(toCode);
  }

  @Override
  public String toString() {
    return String.format("%s%.2f", symbol, value);
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
