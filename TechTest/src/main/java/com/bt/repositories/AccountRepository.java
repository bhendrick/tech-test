package main.java.com.bt.repositories;

import java.math.BigDecimal;
import java.util.List;

import main.java.com.bt.bank.Account;
import main.java.com.bt.bank.Customer;

public interface AccountRepository {
  public Account getAccountByCustomer(Customer customer);

  public void updateAccountBalance(Account account);

  public Account createAccount(Customer customer, BigDecimal balance);

  public List<Account> getAll();
}
