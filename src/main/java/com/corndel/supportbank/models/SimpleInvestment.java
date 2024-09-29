package com.corndel.supportbank.models;

public class SimpleInvestment extends Investment {
  public SimpleInvestment(double rate, Currency amount) {
    super(rate, amount);
  }

  /**
   * Increments the amount invested according to the simple interest formula.
   *
   * A = P(1 + rt)
   *
   * Where:
   * A = the future value of the investment/loan, including interest
   * P = principal investment amount (the initial deposit or loan amount)
   * r = annual interest rate (in decimal)
   * t = time the money is invested or borrowed for, in years
   */
  @Override
  public void increment() {
    var delta = getPrincipal() * getRate() / 100;
    amount.setValue(amount.getValue() + delta);
  }
}
