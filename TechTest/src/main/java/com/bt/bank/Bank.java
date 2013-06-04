package main.java.com.bt.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
  List<Account> accounts = new ArrayList<Account>();

  public Bank() {

  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }

  public Account openAccount(Customer customer, BigDecimal balance) {
    //??
    Account account = new Account(customer, balance);
    accounts.add(account);
    return account;
  }
  /*
   * public Account OpenAccount(Account account) { accounts.add(account); return
   * account; }
   */
}
