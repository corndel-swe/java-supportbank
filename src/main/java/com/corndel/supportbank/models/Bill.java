package com.corndel.supportbank.models;

public class Bill {
  private Currency amount;
  private int people;

  public Bill(Currency amount, int people) {
    this.amount = amount;
    this.people = people;
  }

  /**
   * Add a tip to the bill.
   * 
   * @param tipPercentage
   *                      the tip as a percentage of the bill amount
   */
  public void addTip(double tipPercentage) {
    double tip = tipPercentage / 100 * amount.getValue();
    amount.setValue(amount.getValue() + tip);
  }

  /**
   * Split the bill between the people.
   * 
   * @return the amount that each person owes
   */
  public Currency split() {
    return new Currency(amount.getValue() / people, amount.getCode());
  }

  public Currency getAmount() {
    return amount;
  }
}
