package main.java.com.bt.controllers;

import java.math.BigDecimal;

import main.java.com.bt.bank.Account;
import main.java.com.bt.bank.Bank;
import main.java.com.bt.bank.Customer;
import main.java.com.bt.repositories.AccountRepository;
import main.java.com.bt.repositories.CustomerRepository;

public class BankAccountController {
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
  
  public void create(String firstName, String lastName, String address, String phoneNumber, BigDecimal balance) {
    Bank bank = new Bank();

    Customer newCustomer = customerRepository.createCustomer(firstName, lastName, address, phoneNumber);
    Account newAccount = accountRepository.createAccount(newCustomer, balance);
    //bank.addAccount(newCustomer);
  }

  public void deposit(long id, BigDecimal amount) {
    Customer customer = customerRepository.getCustomerById(id);
    Account account = accountRepository.getAccountByCustomer(customer);
    account.deposit(amount);
    accountRepository.updateAccountBalance(account);
  }

  public void withdraw(long id, BigDecimal amount) {
    Customer customer = customerRepository.getCustomerById(id);
    Account account = accountRepository.getAccountByCustomer(customer);
    account.withdraw(amount);
    accountRepository.updateAccountBalance(account);
  }

}
