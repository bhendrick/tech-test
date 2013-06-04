package main.java.com.bt.exception;

public class AccountOverDrawnException extends Exception {
  private static final long serialVersionUID = 7526472295622776147L;

  public AccountOverDrawnException() {
  }

  public AccountOverDrawnException(String message) {
    super(message);
  }

}
