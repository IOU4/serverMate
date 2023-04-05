package ucode.servermateauth;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ucode.servermateauth.exceptions.UserNotFoundException;
import ucode.servermateauth.model.LoginRequest;
import ucode.servermateauth.model.LoginResponse;
import ucode.servermateauth.user.UserRepository;

/**
 * AuthService
 */
@RequiredArgsConstructor
@Service
public class AuthService {
  private final UserRepository userRepository;

  public LoginResponse login(LoginRequest credentials) {
    var user = userRepository.findByEmail(credentials.email());
    if (user.isPresent())
      return new LoginResponse(user.get().getEmail(), user.get().getUsername());
    throw new UserNotFoundException(credentials.email());
  }
}
