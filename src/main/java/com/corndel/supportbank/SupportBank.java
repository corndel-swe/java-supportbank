package com.corndel.supportbank;

import com.corndel.supportbank.controllers.BillController;
import com.corndel.supportbank.controllers.CurrencyController;
import com.corndel.supportbank.controllers.InvestmentController;
import com.corndel.supportbank.controllers.SalaryController;
import com.corndel.supportbank.controllers.TransactionController;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "supportbank", subcommands = {
    CurrencyController.class,
    InvestmentController.class,
    BillController.class,
    SalaryController.class,
    TransactionController.class
})
public class SupportBank implements Runnable {

  @Override
  public void run() {
    System.out.println("Welcome to Support Bank!");
  }

  public static void main(String[] args) {
    CommandLine cli = new CommandLine(new SupportBank());
    int exitCode = cli.execute(args);
    System.exit(exitCode);
  }
}
