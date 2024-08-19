package com.corndel.supportbank.controllers;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "transaction", description = "Log stuff idk")
public class TransactionController {
  @Command(name = "log", description = "Log transaction data to the console")
  void Log(
      @Parameters(paramLabel = "<from>") String from,
      @Parameters(paramLabel = "<to>") String to,
      @Parameters(
              paramLabel = "<amount>",
              description = "The amount of money transferred in pennies")
          int amount) {
    System.out.println(from + " " + to + " " + Integer.toString(amount));
  }
}
