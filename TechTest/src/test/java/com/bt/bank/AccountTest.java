package test.java.com.bt.bank;

import java.math.BigDecimal;

import main.java.com.bt.bank.Account;
import main.java.com.bt.controllers.AccountController;
import main.java.com.bt.exception.AccountOverDrawnException;
import main.java.com.bt.repositories.impl.AccountRepositoryInMemory;
import main.java.com.bt.repositories.impl.CustomerRepositoryInMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
  private AccountController accountController;

  @Before
  public void setUp() {
    accountController = new AccountController();
    accountController.setCustomerRepository(new CustomerRepositoryInMemory());
    accountController.setAccountRepository(new AccountRepositoryInMemory());
  }

  @Test
  public void testCreateNewAccount() {
    long accId = 12346;

    accountController.create(accId, "Barry", "Hendrick", "Palmerstown, Dublin", "0879802750", new BigDecimal(10.00));
    Account account = accountController.getAccountRepository().getAll().get(0);
    Assert.assertEquals("Barry", account.getCustomer().getFirstName());
    Assert.assertEquals("Hendrick", account.getCustomer().getLastName());
    Assert.assertEquals("Palmerstown, Dublin", account.getCustomer().getAddress());
    Assert.assertEquals("0879802750", account.getCustomer().getPhoneNumber());
    Assert.assertTrue("ID > 0", account.getCustomer().getId() > 0);
  }

  @Test
  public void testDepositMoney() {
    long accId = 12347;
    accountController.create(accId, "Barry", "Hendrick", "Palmerstown, Dublin", "0879802750", new BigDecimal(10.00));
    accountController.deposit(accId, new BigDecimal(500));
    Account account = accountController.getAccountRepository().getAccountById(accId);
    Assert.assertEquals(new BigDecimal(510), account.getBalance());
  }

  @Test
  public void testWithdrawMoney() {
    long accId = 12348;
    accountController.create(accId, "Barry", "Hendrick", "Palmerstown, Dublin", "0879802750", new BigDecimal(0.00));
    accountController.deposit(accId, new BigDecimal(500));
    try {
      accountController.withdraw(accId, new BigDecimal(200));
      Account account = accountController.getAccountRepository().getAccountById(accId);
      Assert.assertEquals(new BigDecimal(300), account.getBalance());
    } catch (AccountOverDrawnException e) {
      e.printStackTrace();
    }
  }

  @Test(expected = AccountOverDrawnException.class)
  public void testOverdrawingAccount() throws AccountOverDrawnException {
    long accId = 12349;

    accountController.create(accId, "Barry", "Hendrick", "Palmerstown, Dublin", "0879802750", new BigDecimal(0.00));
    accountController.deposit(accId, new BigDecimal(500));

    try {
      accountController.withdraw(accId, new BigDecimal(600));
    } finally {
      Account account = accountController.getAccountRepository().getAccountById(accId);
      Assert.assertEquals("Balance should be original value", new BigDecimal(500), account.getBalance());
    }

  }
}