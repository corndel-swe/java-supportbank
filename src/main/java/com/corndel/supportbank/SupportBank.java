package com.corndel.supportbank;

import com.corndel.supportbank.controllers.TransactionController;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "supportbank", description = "Does bank stuff lol")
public class SupportBank {
  @Command(name = "echo", description = "Test echo command")
  int echo(
      @Parameters(arity = "1..*", description = "The string(s) to print back") String[] strings) {
    System.out.println(String.join(" ", strings));
    return CommandLine.ExitCode.OK;
  }

  public static void main(String[] args) {
    CommandLine cmd = new CommandLine(new SupportBank());
    cmd.addSubcommand("transaction", new TransactionController());

    int exitCode = cmd.execute(args);

    System.exit(exitCode);
  }
}
