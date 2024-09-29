package com.corndel.supportbank.controllers;

import com.corndel.supportbank.models.Currency;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "currency", subcommands = { Convert.class })
public class CurrencyController {
}

@Command(name = "convert")
class Convert implements Runnable {

  @Parameters(index = "0", description = "The amount to convert")
  private double amount;

  @Parameters(index = "1", description = "The currency to convert from")
  private String fromCode;

  @Parameters(index = "2", description = "The currency to convert to")
  private String toCode;

  /**
   * Refresh the currency exchange rates, convert the given amount from the
   * given currency to the given currency, and print the result.
   */
  @Override
  public void run() {
    Currency.refreshRates();
    Currency money = new Currency(amount, fromCode);
    money.convert(toCode);
    System.out.println(money);
  }
}