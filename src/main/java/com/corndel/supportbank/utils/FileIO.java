package com.corndel.supportbank.utils;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class FileIO {
  private Path filePath;

  public FileIO(String fileName) {
    this.filePath = Paths.get("src", "data", fileName);
  }

  public List<String> readLines() throws IOException {
    return Files.readAllLines(this.filePath);
  }

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