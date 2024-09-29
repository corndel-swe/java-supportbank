package com.corndel.supportbank.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
  @JsonProperty("FromAccount")
  private Account from;

  @JsonProperty("ToAccount")
  private Account to;

  @JsonProperty("Amount")
  private double value;

  @JsonProperty("Currency")
  private String code = "GBP";

  public Transaction(Account from, Account to, double value, String code) {
    this.from = from;
    this.to = to;
    this.value = value;
    this.code = code;
  }

  public Transaction() {
  }

  /**
   * Subtract the transaction amount from the "from" account and add it to the
   * "to" account.
   */
  public void commit() {
    var amount = new Currency(value, code);
    from.getBalance().subtract(amount);
    to.getBalance().add(amount);
  }

  @Override
  public String toString() {
    return String.format("Transaction [from=%s, to=%s, value=%s, code=%s]", from, to, value, code);
  }
}
