package ucode.servermateauth.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JpaUserRepository
 */
@Repository
public interface JpaUserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
