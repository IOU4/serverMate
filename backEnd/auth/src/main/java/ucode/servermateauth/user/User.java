package ucode.servermateauth.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * User
 */

@Entity
@Table(name = "clients")
@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
public class User {

  private @GeneratedValue @Id long id;
  private String username;
  private String email;
  private String password;
}
