package com.corndel.supportbank.models;

public class Balance extends Currency {
  public Balance(double value, String code) {
    super(value, code);
  }

  /**
   * Add the given amount to the balance, converting to the balance currency first
   * if necessary.
   *
   * @param amount the amount to add
   */
  public void add(Currency amount) {
    amount.convert(getCode());
    this.setValue(this.getValue() + amount.getValue());
  }

  /**
   * Subtract the given amount from the balance, converting to the balance
   * currency first if necessary.
   *
   * @param amount the amount to subtract
   */
  public void subtract(Currency amount) {
    amount.convert(getCode());
    this.setValue(this.getValue() - amount.getValue());
  }
}
