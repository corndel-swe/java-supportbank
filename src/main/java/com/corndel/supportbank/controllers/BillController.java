package com.corndel.supportbank.controllers;

import com.corndel.supportbank.models.Bill;
import com.corndel.supportbank.models.Currency;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "bill", description = "Bill command", subcommands = { BillSplit.class })
public class BillController {
}

@Command(name = "split")
class BillSplit implements Runnable {
  @Parameters(index = "0", description = "The total bill amount.")
  private double amount;

  @Parameters(index = "1", description = "The currency of the bill.")
  private String currency;

  @Parameters(index = "2", description = "The number of people to split the bill with.")
  private int people;

  @Option(names = { "-t", "--tip" }, description = "The optional tip percentage.")
  private double tip = 0.0; // default value if not provided

  /**
   * Print the amount that each person owes, given the total bill amount and the
   * number of people to split it with.
   */
  @Override
  public void run() {
    Bill bill = new Bill(new Currency(amount, currency), people);
    bill.addTip(tip);
    String msg = String.format("Each person owes: %s", bill.split());
    System.out.println(msg);
  }
}