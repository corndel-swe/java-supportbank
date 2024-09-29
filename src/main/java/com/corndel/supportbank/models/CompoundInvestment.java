package com.corndel.supportbank.models;

public class CompoundInvestment extends Investment {
  public CompoundInvestment(double rate, Currency amount) {
    super(rate, amount);
  }

  /**
   * Increments the amount invested according to the compound interest formula.
   *
   * A = P * (1 + r/n)^(nt)
   *
   * Where:
   * A = the future value of the investment/loan, including interest
   * P = principal investment amount (the initial deposit or loan amount)
   * r = annual interest rate (in decimal)
   * n = number of times that interest is compounded per year
   * t = time the money is invested or borrowed for, in years
   */
  @Override
  public void increment() {
    var delta = amount.getValue() * getRate() / 100;
    amount.setValue(amount.getValue() + delta);
  }
}
