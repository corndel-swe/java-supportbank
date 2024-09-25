package com.corndel.supportbank.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import picocli.CommandLine;

public class D1E4Test {
  @Test
  public void testColorSubcommand() throws Exception {
    // Capture the system output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // Instantiate the Hello class
    HelloWorld app = new HelloWorld();

    // Create a CommandLine instance with the app
    CommandLine cli = new CommandLine(app);

    // Execute the command with an argument
    cli.execute("color");

    // Verify the output
    String output = outContent.toString().trim();
    String expectedPrefix = "Today you should wear ";

    assertTrue(output.startsWith(expectedPrefix), "The color subcommand output is incorrect");
  }
}
