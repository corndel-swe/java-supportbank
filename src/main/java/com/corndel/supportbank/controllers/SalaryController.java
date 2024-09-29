package com.corndel.supportbank.controllers;

import com.corndel.supportbank.models.Salary;
import com.corndel.supportbank.models.Currency;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "salary", description = "Salary command", subcommands = { TaxCalculator.class })
public class SalaryController {
}

@Command(name = "tax")
class TaxCalculator implements Runnable {
  @Parameters(index = "0", description = "The total salary amount.")
  private double amount;

  @Parameters(index = "1", description = "The currency of the salary.")
  private String currency;

  @Override
  public void run() {
    Salary salary = new Salary(new Currency(amount, currency));
    salary.applyTax();
    System.out.println(salary.getAmount());
  }
}