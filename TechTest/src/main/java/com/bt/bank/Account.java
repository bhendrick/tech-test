package main.java.com.bt.bank;

import java.math.BigDecimal;

public class Account {
  public Customer customer;
  public long id;
  public BigDecimal balance;

  // this will simulate an identity value from a database
  static long i = 0;

  public Account(Customer customer, BigDecimal balance) {
    this.id = ++i;
    this.customer = customer;
    this.balance = balance;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public void deposit(BigDecimal amount) {
    setBalance(balance.add(amount));
  }

  public void withdraw(BigDecimal amount) {
    BigDecimal provisionalBalance = balance.subtract(amount);
    if (provisionalBalance.compareTo(BigDecimal.ZERO) > 0) {
      setBalance(provisionalBalance);
    }
  }

}
