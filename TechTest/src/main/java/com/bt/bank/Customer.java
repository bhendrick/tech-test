package main.java.com.bt.bank;

public class Customer {
  public long id;
  public String firstName;
  public String lastName;
  public String address;
  public String phoneNumber;

  // this will simulate an identity value from a database
  static long i = 0;

  public Customer(String firstName, String lastName, String address, String phoneNumber) {
    this.id = ++i;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  public long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }
}
