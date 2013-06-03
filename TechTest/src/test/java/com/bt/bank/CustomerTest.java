package test.java.com.bt.bank;

import main.java.com.bt.bank.Customer;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

  @Test
  public void testCreatingCustomer() {
    Customer account = new Customer("Barry", "Hendrick", "Palmerstown, Dublin", "0879802750");
    Assert.assertEquals("Barry", account.getFirstName());
    Assert.assertEquals("Hendrick", account.getLastName());
    Assert.assertEquals("Palmerstown, Dublin", account.getAddress());
    Assert.assertEquals("0879802750", account.getPhoneNumber());
    Assert.assertTrue("ID > 0", account.getId() > 0);
  }

  @Test
  public void testCreateMoreThanOneAccount() {
    Customer firstCustomer = new Customer("Barry", "Hendrick", "Palmerstown, Dublin", "0879802750");
    Assert.assertEquals("Barry", firstCustomer.getFirstName());
    Assert.assertEquals("Hendrick", firstCustomer.getLastName());
    Assert.assertEquals("Palmerstown, Dublin", firstCustomer.getAddress());
    Assert.assertEquals("0879802750", firstCustomer.getPhoneNumber());
    Assert.assertTrue("ID > 0", firstCustomer.getId() > 0);

    Customer secondCustomer = new Customer("Dan", "Hendrick", "Palmerstown, Dublin", "0879802750");
    Assert.assertEquals("Dan", secondCustomer.getFirstName());
    Assert.assertEquals("Hendrick", secondCustomer.getLastName());
    Assert.assertEquals("Palmerstown, Dublin", secondCustomer.getAddress());
    Assert.assertEquals("0879802750", secondCustomer.getPhoneNumber());
    Assert.assertTrue("ID > 0", secondCustomer.getId() > 0);

    Assert.assertNotSame("IDs should be unique", firstCustomer.getId(), secondCustomer.getId());
  }
}
