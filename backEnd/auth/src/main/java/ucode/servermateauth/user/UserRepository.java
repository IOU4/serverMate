package ucode.servermateauth.user;

import java.util.Optional;

import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository {

  Optional<User> findById(long id);

  Optional<User> findByEmail(String email);

  long save(User user);
}
