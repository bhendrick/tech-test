package main.java.com.bt.bank;

public class Customer {
  public long id;
  public String firstName;
  public String lastName;
  public String address;
  public String phoneNumber;

  // this will simulate an identity value from a database
  static long i = 0;

  public Customer(String FirstName, String LastName, String addresss, String phoneNumber) {
    id = ++i;
    firstName = FirstName;
    lastName = LastName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
