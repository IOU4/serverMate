package ucode.servermateauth;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ucode.servermateauth.exceptions.UserAlreadyExistsException;
import ucode.servermateauth.exceptions.UserNotFoundException;
import ucode.servermateauth.model.LoginRequest;
import ucode.servermateauth.model.RegisterRequest;
import ucode.servermateauth.model.AuthResponse;
import ucode.servermateauth.user.User;
import ucode.servermateauth.user.UserRepository;

/**
 * AuthService
 */
@RequiredArgsConstructor
@Service
public class AuthService {
  private final UserRepository userRepository;

  public AuthResponse login(LoginRequest credentials) {
    var user = userRepository.findByEmail(credentials.email());
    if (user.isPresent())
      return new AuthResponse(user.get().getEmail(), user.get().getUsername());
    throw new UserNotFoundException(credentials.email());
  }

  public AuthResponse register(RegisterRequest user) {
    if (userRepository.findByEmail(user.email()).isPresent())
      throw new UserAlreadyExistsException(user.email());
    var createdId = userRepository
        .save(User.builder().email(user.email()).username(user.username()).password(user.password()).build());
    var createdUser = userRepository.findById(createdId).get();
    return new AuthResponse(createdUser.getEmail(), createdUser.getUsername());
  }
}
