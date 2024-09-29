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
}