package com.corndel.supportbank.controllers;

import com.corndel.supportbank.models.CompoundInvestment;
import com.corndel.supportbank.models.Currency;
import com.corndel.supportbank.models.Investment;
import com.corndel.supportbank.models.SimpleInvestment;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "invest", subcommands = { InvestSimple.class, InvestCompound.class })
public class InvestmentController {
}

@Command(name = "simple")
class InvestSimple implements Runnable {
  @Parameters(index = "0", description = "The amount to invest")
  private double amount;

  @Parameters(index = "1", description = "The currency to invest in")
  private String currency;

  @Parameters(index = "2", description = "The interest rate")
  private double rate;

  @Parameters(index = "3", description = "The number of years to invest")
  private int years;

  @Override
  public void run() {
    Investment investment = new SimpleInvestment(rate, new Currency(amount, currency));

    for (int i = 0; i < years; i++) {
      investment.increment();
    }

    System.out.println(investment.getAmount());
  }
}

@Command(name = "compound")
class InvestCompound implements Runnable {
  @Parameters(index = "0", description = "The amount to invest")
  private double amount;

  @Parameters(index = "1", description = "The currency to invest in")
  private String currency;

  @Parameters(index = "2", description = "The interest rate")
  private double rate;

  @Parameters(index = "3", description = "The number of years to invest")
  private int years;

  @Override
  public void run() {
    Investment investment = new CompoundInvestment(rate, new Currency(amount, currency));

    for (int i = 0; i < years; i++) {
      investment.increment();
    }

    System.out.println(investment.getAmount());
  }
}