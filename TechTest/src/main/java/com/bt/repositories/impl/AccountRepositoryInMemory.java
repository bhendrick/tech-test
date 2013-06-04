package main.java.com.bt.repositories.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import main.java.com.bt.bank.Account;
import main.java.com.bt.bank.Customer;
import main.java.com.bt.repositories.AccountRepository;

public class AccountRepositoryInMemory implements AccountRepository {
  private List<Account> accounts = new ArrayList<Account>();

  public Account createAccount(long id, Customer customer, BigDecimal balance) {
    Account accountToSave = new Account(id, customer, balance);
    accounts.add(accountToSave);
    return accountToSave;
  }

  public List<Account> getAll() {
    return accounts;
  }

  public Account getAccountById(long id) {
    Account accountReturn = null;
    for (Account account : accounts) {
      if (id == account.getId()) {
        accountReturn = account;
      }
    }

    return accountReturn;
  }
}
