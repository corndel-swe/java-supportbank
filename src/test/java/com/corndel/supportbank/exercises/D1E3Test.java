package com.corndel.supportbank.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;

public class D1E3Test {

  @Test
  public void testHelloClassWithParameter() throws Exception {
    Class<?> clazz = Class.forName("com.corndel.supportbank.exercises.HelloWorld");
    assertNotNull(clazz, "Class com.corndel.supportbank.exercises.HelloWorld not found");

    // Check for a field annotated with @Parameters
    Field[] fields = clazz.getDeclaredFields();
    boolean hasNameField = false;

    for (Field field : fields) {
      if (field.isAnnotationPresent(Parameters.class)) {
        Parameters params = field.getAnnotation(Parameters.class);
        if (params.defaultValue().equals("World")) {
          hasNameField = true;
          break;
        }
      }
    }

    assertTrue(hasNameField, "Not field with @Parameters annotation and default value \"World\" found");
  }

  @Test
  public void testHelloCliWithArgument() throws Exception {
    // Capture the system output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // Instantiate the Hello class
    HelloWorld app = new HelloWorld();

    // Create a CommandLine instance with the app
    CommandLine cli = new CommandLine(app);

    // Execute the command with an argument
    cli.execute("Alice");

    // Verify the output
    String output = outContent.toString().trim();
    assertEquals("Hello, Alice!", output, "The CLI output is incorrect when an argument is provided");
  }
}
