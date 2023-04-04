package ucode.servermateauth;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import ucode.servermateauth.model.LoginRequest;
import ucode.servermateauth.model.LoginResponse;

/**
 * AuthController
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

  private final AuthService authService;

  @GetMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest credentials) {
    return ResponseEntity.ok(authService.login(credentials));
  }

}
