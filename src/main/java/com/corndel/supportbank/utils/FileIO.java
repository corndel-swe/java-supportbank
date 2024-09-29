package com.corndel.supportbank.utils;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class FileIO {
  private Path filePath;

  public FileIO(String fileName) {
    this.filePath = Paths.get("src", "data", fileName);
  }

  /**
   * Reads all lines from a file and returns them as a List of Strings.
   * 
   * @return A list of all lines in the file.
   * @throws IOException if an error occurs while reading the file.
   */
  public List<String> readLines() throws IOException {
    return Files.readAllLines(this.filePath);
  }

  /**
   * Reads all lines from a file and returns them as a single String.
   * 
   * @return The contents of the file as a single String.
   * @throws IOException if an error occurs while reading the file.
   */
  public String readFile() throws IOException {
    List<String> lines = readLines();
    return String.join("", lines);
  }

  public String readLine(int i) throws IOException {
    List<String> lines = this.readLines();
    return lines.get(i);
  }

  public void appendLine(String line) throws IOException {
    Files.write(this.filePath, List.of(line), StandardOpenOption.APPEND);
  }

  public void appendLines(List<String> lines) throws IOException {
    Files.write(this.filePath, lines, StandardOpenOption.APPEND);
  }
}