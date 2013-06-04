package main.java.com.bt.repositories;

import java.util.List;

import main.java.com.bt.bank.Customer;

public interface CustomerRepository {
  public Customer getCustomerById(long id);
  
  public Customer createCustomer(String firstName, String lastName, String address, String phoneNumber);

  public List<Customer> getAll() throws Exception;
}
