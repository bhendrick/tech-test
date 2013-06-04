package main.java.com.bt.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.bt.bank.Customer;
import main.java.com.bt.repositories.CustomerRepository;

public class CustomerRepositoryInMemory implements CustomerRepository {
  private List<Customer> customers = new ArrayList<Customer>();

  public Customer createCustomer(String firstName, String lastName, String address, String phoneNumber) {
    Customer customer = new Customer(firstName, lastName, address, phoneNumber);
    customers.add(customer);
    return customer;
  }

  public List<Customer> getAll() {
    return customers;
  }

}
