package com.corndel.supportbank.controllers;

import java.util.ArrayList;
import java.util.List;

import com.corndel.supportbank.models.Transaction;
import com.corndel.supportbank.models.Account;
import com.corndel.supportbank.utils.FileIO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "transaction", subcommands = { SummariseTransactions.class })
public class TransactionController {
}

@Command(name = "summarise")
class SummariseTransactions implements Runnable {
  @Parameters(index = "0", description = "The name of the file containing the transactions")
  private String filename;

  /**
   * This method is called when the user runs this command. It will parse the
   * transactions from the given file and commit them to the accounts.
   *
   * <p>
   * It will then print out the state of each of the accounts.
   */
  @Override
  public void run() {
    var parts = filename.split("\\.");
    var ext = parts[parts.length - 1];

    try {
      List<Transaction> transactions = switch (ext) {
        case "csv" -> parseCSV(filename);
        case "json" -> parseJSON(filename);
        default -> throw new IllegalArgumentException("Unexpected extension: " + ext);
      };

      for (var transaction : transactions) {
        System.out.println(transaction);
        transaction.commit();
      }

      for (var user : Account.getAccounts()) {
        System.out.println(user);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Parses a CSV file at the given filename into a list of transactions.
   *
   * <p>
   * The CSV file is expected to be in the following format:
   * 
   * <pre>
   * Date,From,To,Narrative,Amount,Currency
   * </pre>
   *
   * <p>
   * The currency is optional and defaults to GBP.
   *
   * @param filename the filename to parse
   * @return a list of transactions
   * @throws Exception if the file cannot be read or if any of the transactions
   *                   are invalid
   */
  public static List<Transaction> parseCSV(String filename) throws Exception {
    List<Transaction> transactions = new ArrayList<>();

    var file = new FileIO("transactions/" + filename);
    var lines = file.readLines();
    lines.removeFirst(); // remove header row

    for (var line : lines) {
      var parts = line.split(",");

      // parse users
      var fromUsername = parts[1];
      var toUsername = parts[2];
      var fromAccount = Account.getAccount(fromUsername);
      var toAccount = Account.getAccount(toUsername);

      // parse amount
      var value = Double.parseDouble(parts[4]);
      var code = parts.length == 6 ? parts[5] : "GBP";

      transactions.add(new Transaction(fromAccount, toAccount, value, code));
    }

    return transactions;
  }

  /**
   * Parses a JSON file and returns a list of Transaction objects.
   *
   * @param filename The filename of the JSON file to parse.
   * @return A list of Transaction objects.
   * @throws Exception If there is an error parsing the JSON file.
   */
  public static List<Transaction> parseJSON(String filename) throws Exception {
    var file = new FileIO("transactions/" + filename);
    var json = file.readFile();
    var mapper = new ObjectMapper();

    return mapper.readValue(json, new TypeReference<List<Transaction>>() {
    });
  }
}