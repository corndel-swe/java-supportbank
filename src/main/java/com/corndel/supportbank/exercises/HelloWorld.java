package com.corndel.supportbank.exercises;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "hello", subcommands = { ColorCommand.class })
public class HelloWorld implements Runnable {
  @Parameters(index = "0", description = "The name of the person to greet", defaultValue = "World")
  private String name;

  @Override
  public void run() {
    var msg = String.format("Hello, %s!", name);
    System.out.println(msg);
  }

  public static void main(String[] args) {
    var cli = new CommandLine(new HelloWorld());
    int exitCode = cli.execute(args);
    System.exit(exitCode);
  }

}
