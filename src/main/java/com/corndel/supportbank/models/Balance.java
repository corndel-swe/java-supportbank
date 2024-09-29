package com.corndel.supportbank.models;

public class Balance extends Currency {
  public Balance(double value, String code) {
    super(value, code);
  }

  public void add(Currency amount) {
    amount.convert(getCode());
    this.setValue(this.getValue() + amount.getValue());
  }

  public void subtract(Currency amount) {
    amount.convert(getCode());
    this.setValue(this.getValue() - amount.getValue());
  }
}
