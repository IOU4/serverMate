package ucode.servermatecontainers.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.dockerjava.api.exception.NotFoundException;

import ucode.servermatecontainers.exceptions.ContainerNotFoundException;
import ucode.servermatecontainers.model.ErrorResponse;

/**
 * ContainerExceptionHandler
 */
@RestControllerAdvice(annotations = RestController.class)
public class ContainerExceptionHandler {

  @ExceptionHandler({ ContainerNotFoundException.class, NotFoundException.class })
  public ResponseEntity<ErrorResponse> handleNtFound(RuntimeException exception) {
    return ResponseEntity.badRequest()
        .body(new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND));
  }

}
