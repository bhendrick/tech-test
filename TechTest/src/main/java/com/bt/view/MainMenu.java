package main.java.com.bt.view;

import java.math.BigDecimal;
import java.util.Scanner;

import main.java.com.bt.bank.Account;
import main.java.com.bt.controllers.AccountController;
import main.java.com.bt.repositories.impl.AccountRepositoryInMemory;
import main.java.com.bt.repositories.impl.CustomerRepositoryInMemory;

public class MainMenu {

  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {

    AccountController accountController = new AccountController();
    accountController.setCustomerRepository(new CustomerRepositoryInMemory());
    accountController.setAccountRepository(new AccountRepositoryInMemory());

    int menu = 0;
    boolean quit = false;
    do {
      System.out.println("1.Create Account");
      System.out.println("2.Deposit");
      System.out.println("3.Withdraw");
      System.out.println("4.Transfer");
      System.out.println("5.Display all Accounts");
      System.out.println("6.Exit");
      System.out.print("Please enter your choice from the menu: ");
      menu = input.nextInt();
      switch (menu) {
        case 1:
          accCreate(accountController);
          break;
        case 2:
          accDeposit(accountController);
          break;
        case 3:
          accWithdraw(accountController);
          break;
        case 4:
          accTransfer(accountController);
          break;
        case 5:
          accDisplayAll(accountController);
          break;
        case 6:
          quit = true;
          break;
      }
    } while (!quit);

  }

  private static void accDisplayAll(AccountController accountController) {
    for (Account acc : accountController.getAllAccounts()) {
      System.out.println("Acc ID: " + acc.getId() + ", Acc Bal: " + acc.getBalance() + ", Acc Customer ID: " + acc.getCustomer().getId() + ", Acc Customer Name: " + acc.getCustomer().getFirstName()
          + " " + acc.getCustomer().getLastName());
    }
  }

  private static void accWithdraw(AccountController accountController) {
    System.out.println("Enter Account ID to withdraw from: ");
    long id = input.nextLong();

    System.out.println("Enter amount to withdraw: ");
    BigDecimal amount = input.nextBigDecimal();

    accountController.withdraw(id, amount);
  }

  private static void accTransfer(AccountController accountController) {
    System.out.println("Enter Account ID to withdraw from: ");
    long id = input.nextLong();

    System.out.println("Enter amount to withdraw: ");
    BigDecimal amount = input.nextBigDecimal();

    accountController.withdraw(id, amount);

    System.out.println("Enter Account ID to deposit to: ");
    id = input.nextLong();

    accountController.deposit(id, amount);
  }

  private static void accDeposit(AccountController accountController) {
    System.out.println("Enter Account ID to deposit to: ");
    long id = input.nextLong();

    System.out.println("Enter amount to deposit: ");
    BigDecimal amount = input.nextBigDecimal();

    accountController.deposit(id, amount);
  }

  private static void accCreate(AccountController accountController) {
    System.out.println("Enter your Customer First Name: ");
    String firstName = input.next();

    System.out.println("Enter your Customer Last Name: ");
    String lastName = input.next();

    System.out.println("Enter your Customer Address: ");
    String address = input.next();

    System.out.println("Enter your Customer Phonenumber: ");
    String phonenumber = input.next();

    System.out.println("Enter Account Number: ");
    long id = input.nextLong();

    System.out.println("Enter Initial Balance: ");
    BigDecimal balance = input.nextBigDecimal();

    accountController.create(id, firstName, lastName, address, phonenumber, balance);
  }

}
