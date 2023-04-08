package ucode.servermateauth.exceptions;

/**
 * WrongPasswordException
 */
public class WrongPasswordException extends RuntimeException {

  public WrongPasswordException(String email) {
    super("wrong password for user with email: '" + email + "' !");
  }
}
