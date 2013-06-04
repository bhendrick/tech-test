package main.java.com.bt.bank;

import java.math.BigDecimal;

import main.java.com.bt.exception.AccountOverDrawnException;

public class Account {
  public Customer customer;
  public long id;
  public BigDecimal balance;

  public Account(long id, Customer customer, BigDecimal balance) {
    this.id = id;
    this.customer = customer;
    this.balance = balance;
  }

  public Customer getCustomer() {
    return customer;
  }

  public long getId() {
    return id;
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

  public void withdraw(BigDecimal amount) throws AccountOverDrawnException {
    BigDecimal provisionalBalance = balance.subtract(amount);
    if (provisionalBalance.compareTo(BigDecimal.ZERO) > 0) {
      setBalance(provisionalBalance);
    }
    else{
      throw new AccountOverDrawnException();
    }
  }

}
