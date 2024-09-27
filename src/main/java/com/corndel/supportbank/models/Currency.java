package com.corndel.supportbank.models;

public class Currency {
  private double value;
  private String code;
  private double rate;

  public Currency(double value, String code) {
    this.value = value;
    this.code = code;

    if (code.equals("GBP")) {
      this.rate = 1.0;
    } else if (code.equals("EUR")) {
      this.rate = 1.2;
    } else if (code.equals("USD")) {
      this.rate = 1.4;
    } else if (code.equals("JPY")) {
      this.rate = 130.0;
    } else if (code.equals("AUD")) {
      this.rate = 1.5;
    } else {
      throw new IllegalArgumentException("Unknown currency code: " + code);
    }
  }

  public Currency convert(String toCode) {
    Currency to = new Currency(1.0, toCode);
    return new Currency(value * to.getRate() / rate, to.getCode());
  }

  @Override
  public String toString() {
    return String.format("%.2f %s", value, code);
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }
}
