package test.java.com.bt.bank;

import main.java.com.bt.bank.Account;
import main.java.com.bt.bank.Bank;
import main.java.com.bt.bank.Customer;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class AccountTest {

  @Test
  public void testOpeningAccount() {
    Bank bank = new Bank();

    Customer customer = new Customer("Barry", "Hendrick", "Palmerstown, Dublin", "0879802750");
    BigDecimal balance = new BigDecimal(800.00);
    bank.openAccount(customer, balance);

    Assert.assertEquals(1, bank.getAccounts().size());
    Assert.assertEquals(balance, bank.getAccounts().get(0).getBalance());
    Assert.assertEquals(customer, bank.getAccounts().get(0).getCustomer());
    Assert.assertTrue("ID > 0", bank.getAccounts().get(0).getId() > 0);
  }

  @Test
  public void testDepositIntoAccount() {
    Customer customer = new Customer("Barry", "Hendrick", "Palmerstown, Dublin", "0879802750");
    Bank bank = new Bank();
    BigDecimal balance = new BigDecimal(0.00);
    Account account = bank.openAccount(customer, balance);

    account.deposit(new BigDecimal(42.00));
    account.deposit(new BigDecimal(37.00));
    Assert.assertEquals(new BigDecimal(79.00), account.getBalance());
  }

  @Test
  public void testWithdrawFromAccount() {
    Customer customer = new Customer("Barry", "Hendrick", "Palmerstown, Dublin", "0879802750");
    Bank bank = new Bank();
    BigDecimal balance = new BigDecimal(0.00);
    Account account = bank.openAccount(customer, balance);

    account.deposit(new BigDecimal(50.00));
    account.withdraw(new BigDecimal(10.00));
    Assert.assertEquals(new BigDecimal(40), account.getBalance());
  }

  @Test
  public void testOverdrawingAccount() {
    Customer customer = new Customer("Barry", "Hendrick", "Palmerstown, Dublin", "0879802750");
    Bank bank = new Bank();
    BigDecimal balance = new BigDecimal(5.00);
    Account account = bank.openAccount(customer, balance);

    account.withdraw(new BigDecimal(10.00));
    Assert.assertEquals("Balance should be original value", balance, account.getBalance());
  }

}