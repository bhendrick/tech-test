package main.java.com.bt.controllers;

import java.math.BigDecimal;
import java.util.List;

import main.java.com.bt.bank.Account;
import main.java.com.bt.bank.Customer;
import main.java.com.bt.exception.AccountOverDrawnException;
import main.java.com.bt.repositories.AccountRepository;
import main.java.com.bt.repositories.CustomerRepository;

public class AccountController {
  public CustomerRepository customerRepository;
  public AccountRepository accountRepository;

  public void setCustomerRepository(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public CustomerRepository getCustomerRepository() {
    return customerRepository;
  }

  public void setAccountRepository(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public AccountRepository getAccountRepository() {
    return accountRepository;
  }

  public void create(long id, String firstName, String lastName, String address, String phoneNumber, BigDecimal balance) {
    Customer newCustomer = customerRepository.createCustomer(firstName, lastName, address, phoneNumber);
    accountRepository.createAccount(id, newCustomer, balance);
  }

  public List<Account> getAllAccounts() {
    return accountRepository.getAll();
  }

  public void deposit(long id, BigDecimal amount) {
    Account account = accountRepository.getAccountById(id);
    account.deposit(amount);
  }

  public void withdraw(long id, BigDecimal amount) throws AccountOverDrawnException {
    Account account = accountRepository.getAccountById(id);
    account.withdraw(amount);
  }

}
