package com.corndel.supportbank.exercises;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class D2E1Test {

  @Test
  public void testValidId() {
    String validId = "abcde"; // Valid ID: odd length, contains 'a', all lowercase
    UserId userId = new UserId(validId);

    assertDoesNotThrow(() -> {
      boolean result = userId.validate();
      assertTrue(result, "validate should return true for a valid ID");
    });
  }

  @Test
  public void testEvenLengthId() {
    String invalidId = "abcd"; // Even number of characters
    UserId userId = new UserId(invalidId);

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      userId.validate();
    });

    String expectedMessage = "The id must be an odd number of characters long";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage), "Exception message should mention odd length requirement");
  }

  @Test
  public void testIdWithoutLetterA() {
    String invalidId = "bcdef"; // Does not contain 'a'
    UserId userId = new UserId(invalidId);

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      userId.validate();
    });

    String expectedMessage = "The id must contain the letter 'a'";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage), "Exception message should mention missing 'a'");
  }

  @Test
  public void testIdNotAllLowercase() {
    String invalidId = "aBcde"; // Contains uppercase letter
    UserId userId = new UserId(invalidId);

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      userId.validate();
    });

    String expectedMessage = "The id must be all lowercase";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage), "Exception message should mention lowercase requirement");
  }
}
