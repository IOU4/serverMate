package ucode.servermateauth.exceptions;

/**
 * UserAlreadyExistsException
 */
public class UserAlreadyExistsException extends RuntimeException {
  public UserAlreadyExistsException(String email) {
    super("user with email: '" + email + "' alread exists!");
  }
}
