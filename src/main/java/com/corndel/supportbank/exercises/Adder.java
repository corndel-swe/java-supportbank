package com.corndel.supportbank.exercises;

import java.nio.file.*;

public class Adder {
  /**
   * This method reads a file line by line and adds up the numbers on each line.
   * It uses try/catch to print "Something went wrong" and
   * returns 0 in case of an exception.
   *
   * @param fileName The name of the file to be read.
   * @return The sum of the numbers in the file.
   */
  public int add(String fileName) {
    try {
      var file = Paths.get("src", "data", fileName);
      var lines = Files.readAllLines(file);
      var total = 0;

      for (var line : lines) {
        total += Integer.parseInt(line);
      }

      return total;
    } catch (Exception e) {
      System.out.println("Something went wrong");
      return 0;
    }
  }

  /**
   * Calls the add method and prints the result.
   * This method is for debugging purposes only.
   */
  public static void main(String[] args) {
    Adder adder = new Adder();
    System.out.println(adder.add("nums.txt"));
  }
}
