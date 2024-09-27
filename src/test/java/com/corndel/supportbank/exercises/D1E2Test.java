package com.corndel.supportbank.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import picocli.CommandLine;
import picocli.CommandLine.Command;

public class D1E2Test {

  @Test
  public void testHelloWorldClass() throws Exception {
    Class<?> clazz = Class.forName("com.corndel.supportbank.exercises.HelloWorld");
    assertNotNull(clazz, "Class com.corndel.supportbank.exercises.HelloWorld not found");

    // Check if the class is annotated with @Command
    Command commandAnnotation = clazz.getAnnotation(Command.class);
    assertNotNull(commandAnnotation, "Class HelloWorld is not annotated with @Command");

    // Verify the command name and description
    assertEquals("hello", commandAnnotation.name(), "Command name should be 'hello'");

    // Check if the class implements Runnable
    assertTrue(Runnable.class.isAssignableFrom(clazz), "Class HelloWorld does not implement Runnable");
  }

  @Test
  public void testHelloWorldCliOutput() throws Exception {
    // Capture the system output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // Instantiate the App class
    HelloWorld app = new HelloWorld();

    // Create a CommandLine instance with the app
    CommandLine cli = new CommandLine(app);

    // Execute the command with no arguments
    int exitCode = cli.execute();

    // Verify the output
    String output = outContent.toString().trim();
    assertEquals("Hello, World!", output, "The CLI output is incorrect");

    // Optionally, verify the exit code
    assertEquals(0, exitCode, "The exit code should be 0");
  }
}
