package ucode.servermateauth.exceptions;

/**
 * UserNotFoundException
 */
public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(long id) {
    super("user with id: '" + id + "' not found!");
  }

  public UserNotFoundException(String email) {
    super("user with email: '" + email + "' not found!");
  }
}
