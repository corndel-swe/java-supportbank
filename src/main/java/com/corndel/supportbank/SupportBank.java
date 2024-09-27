package com.corndel.supportbank;

import com.corndel.supportbank.controllers.CurrencyController;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "supportbank", subcommands = { CurrencyController.class })
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
