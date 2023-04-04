package ucode.servermateauth.user;

import java.util.Optional;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * JpaUserRepository
 */
@RequiredArgsConstructor
@Component
public class PostgresUserRepository implements UserRepository {

  private final JpaUserRepository JpaUserRepository;

  @Override
  public Optional<User> findById(long id) {
    return JpaUserRepository.findById(id);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return JpaUserRepository.findByEmail(email);
  }

  @Override
  public long save(User user) {
    return JpaUserRepository.save(user).getId();
  }

}
