package com.corndel.supportbank.models;

import java.util.List;

public class Salary {
  private Currency amount;

  public static final List<Integer> rates = List.of(0, 20, 40, 45);

  public static final List<Integer> thresholds = List.of(0, 12571, 50271, 125141);

  public Salary(Currency salary) {
    this.amount = salary;
  }

  /**
   * Calculate the salary after tax.
   *
   * This method calculates the salary after tax by summing the tax for each
   * band. The tax for each band is calculated by multiplying the rate by the
   * taxable income. The taxable income is the minimum of the salary and the
   * upper threshold minus the lower threshold. The loop breaks if the salary is
   * less than or equal to the upper threshold.
   *
   * @return the salary after tax
   */
  public void applyTax() {
    double tax = 0;

    for (int i = 1; i < rates.size(); i++) {
      int lower = thresholds.get(i - 1);
      int upper = thresholds.get(i);
      double rate = rates.get(i - 1) / 100.0;
      double taxable = Math.min(amount.getValue(), upper) - lower;
      tax += rate * taxable;

      if (amount.getValue() <= upper) {
        break;
      }
    }

    amount.setValue(amount.getValue() - tax);
  }

  public Currency getAmount() {
    return amount;
  }
}
