package ucode.servermatecontainers.model;

import org.springframework.http.HttpStatus;

/**
 * SuccessResponse
 */
public record SuccessResponse(String message, HttpStatus status) {
}
