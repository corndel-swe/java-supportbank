package com.corndel.supportbank.models;

public abstract class Investment {
  protected double rate;
  protected Currency amount;
  protected double principal;

  public Investment(double rate, Currency amount) {
    this.rate = rate;
    this.amount = amount;
    this.principal = amount.getValue();
  }

  public abstract void increment();

  public double getRate() {
    return rate;
  }

  public Currency getAmount() {
    return amount;
  }

  public double getPrincipal() {
    return principal;
  }

}