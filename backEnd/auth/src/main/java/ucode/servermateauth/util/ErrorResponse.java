package ucode.servermateauth.util;

import org.springframework.http.HttpStatus;

/**
 * ErrorResponse
 */
public record ErrorResponse(String message, HttpStatus status) {
}
