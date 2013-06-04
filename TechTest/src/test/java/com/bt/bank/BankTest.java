package test.java.com.bt.bank;

import java.math.BigDecimal;

import main.java.com.bt.bank.Account;
import main.java.com.bt.bank.Customer;
import main.java.com.bt.controllers.BankAccountController;
import main.java.com.bt.repositories.impl.AccountRepositoryInMemory;
import main.java.com.bt.repositories.impl.CustomerRepositoryInMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
  private BankAccountController bankAccountController;

  @Before
  public void setUp() {
    bankAccountController = new BankAccountController();
    bankAccountController.setCustomerRepository(new CustomerRepositoryInMemory());
    bankAccountController.setAccountRepository(new AccountRepositoryInMemory());
  }

  @Test
  public void testCreateNewCustomer() throws Exception {
    bankAccountController.create("Barry", "Hendrick", "Palmerstown, Dublin", "0879802750", new BigDecimal(10.00));
    Customer customer = bankAccountController.getCustomerRepository().getAll().get(0);
    Assert.assertEquals("Barry", customer.getFirstName());
    Assert.assertEquals("Hendrick", customer.getLastName());
    Assert.assertEquals("Palmerstown, Dublin", customer.getAddress());
    Assert.assertEquals("0879802750", customer.getPhoneNumber());
    Assert.assertTrue("ID > 0", customer.getId() > 0);
  }

  @Test
  public void testCreateNewAccount() throws Exception {
    bankAccountController.create("Barry", "Hendrick", "Palmerstown, Dublin", "0879802750", new BigDecimal(10.00));
    Account account = bankAccountController.getAccountRepository().getAll().get(0);    
    Assert.assertEquals("Barry", account.getCustomer().getFirstName());
    Assert.assertEquals("Hendrick", account.getCustomer().getLastName());
    Assert.assertEquals("Palmerstown, Dublin", account.getCustomer().getAddress());
    Assert.assertEquals("0879802750", account.getCustomer().getPhoneNumber());
    Assert.assertTrue("ID > 0", account.getCustomer().getId() > 0);
  }

  @Test
  public void testDepositMoney() throws Exception {
    bankAccountController.create("Barry", "Hendrick", "Palmerstown, Dublin", "0879802750", new BigDecimal(10.00));
    Customer customer = bankAccountController.getCustomerRepository().getAll().get(0);
    bankAccountController.deposit(customer.getId(), new BigDecimal(500));
    Account account = bankAccountController.getAccountRepository().getAll().get(0);
    Assert.assertEquals(new BigDecimal(510), account.getBalance());
  }

  @Test
  public void testWithdrawMoney() throws Exception {
    bankAccountController.create("Barry", "Hendrick", "Palmerstown, Dublin", "0879802750", new BigDecimal(0.00));
    Customer customer = bankAccountController.getCustomerRepository().getAll().get(0);
    bankAccountController.deposit(customer.getId(), new BigDecimal(500));
    bankAccountController.withdraw(customer.getId(), new BigDecimal(200));
    Account account = bankAccountController.getAccountRepository().getAll().get(0);
    Assert.assertEquals(new BigDecimal(300), account.getBalance());
  }
}