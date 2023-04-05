package ucode.servermateauth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ucode.servermateauth.exceptions.UserNotFoundException;
import ucode.servermateauth.util.ErrorResponse;

/**
 * AuthExceptionHandler
 */
@RestControllerAdvice(annotations = RestController.class)
public class AuthExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException exception) {
    return ResponseEntity
        .badRequest()
        .body(new ErrorResponse("user with specified email not found", HttpStatus.NOT_FOUND));
  }
}
