package com.corndel.supportbank.exercises;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class D2E2Test {

  @Test
  public void testAdderWithValidFile() {
    Adder adder = new Adder();
    int expectedSum = 51679;
    int actualSum = adder.add("nums.txt");
    assertEquals(expectedSum, actualSum, "The sum of numbers in nums.txt should be " + expectedSum);
  }

  @Test
  public void testAdderWithNonExistentFile() {
    // Redirect standard error to capture error messages
    java.io.ByteArrayOutputStream errContent = new java.io.ByteArrayOutputStream();
    System.setErr(new java.io.PrintStream(errContent));

    Adder adder = new Adder();
    int result = adder.add("nonexistent.txt");

    // Reset standard error
    System.setErr(System.err);

    String errorOutput = errContent.toString().trim();

    assertEquals(0, result, "Adder.add should return 0 when file does not exist");
    assertTrue(errorOutput.contains("Something went wrong"), "Error message should be printed when file is missing");
  }
}