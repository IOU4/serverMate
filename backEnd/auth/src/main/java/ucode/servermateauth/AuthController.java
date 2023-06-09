package ucode.servermateauth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ucode.servermateauth.model.AuthResponse;
import ucode.servermateauth.model.LoginRequest;
import ucode.servermateauth.model.RegisterRequest;

/**
 * AuthController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest credentials) {
    return ResponseEntity.ok(authService.login(credentials));
  }

  @PostMapping("/register")
  public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest user) {
    return ResponseEntity.ok(authService.register(user));
  }
}
