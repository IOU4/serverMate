package ucode.servermateauth.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ucode.servermateauth.exceptions.UserAlreadyExistsException;
import ucode.servermateauth.exceptions.UserNotFoundException;
import ucode.servermateauth.exceptions.WrongPasswordException;
import ucode.servermateauth.model.ErrorResponse;

/**
 * AuthExceptionHandler
 */
@RestControllerAdvice(annotations = RestController.class)
public class AuthExceptionHandler {

  @ExceptionHandler({ UserNotFoundException.class, UserAlreadyExistsException.class, WrongPasswordException.class })
  public ResponseEntity<ErrorResponse> handleUserNotFound(RuntimeException exception) {
    return ResponseEntity
        .badRequest()
        .body(new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST));
  }
}
