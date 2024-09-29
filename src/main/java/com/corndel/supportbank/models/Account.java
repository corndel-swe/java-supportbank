package com.corndel.supportbank.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {
  public static Map<String, Account> accounts = new HashMap<>();

  /**
   * Retrieves an Account object from the accounts map. If the account doesn't
   * exist yet, it creates a new one.
   *
   * @param username the username of the account to retrieve
   * @return an Account object
   */
  public static Account getAccount(String username) {
    if (accounts.containsKey(username)) {
      return accounts.get(username);
    } else {
      return new Account(username);
    }
  }

  /**
   * Returns a list of all accounts.
   *
   * @return a list of Account objects
   */
  public static List<Account> getAccounts() {
    return List.copyOf(accounts.values());
  }

  private String username;
  private Balance balance;

  public Account(String username) {
    this.username = username;
    this.balance = new Balance(0, "GBP");
    accounts.put(username, this);
  }

  public String getUsername() {
    return username;
  }

  public Balance getBalance() {
    return balance;
  }

  @Override
  public String toString() {
    return String.format("Account [username=%s, balance=%s]", username, balance);
  }
}
