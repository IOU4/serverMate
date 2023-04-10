package ucode.servermatecontainers.model;

import org.springframework.http.HttpStatus;

/**
 * ErrorResponse
 */
public record ErrorResponse(String message, HttpStatus status) {
}
