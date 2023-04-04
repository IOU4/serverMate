package ucode.servermateauth.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * User
 */

@Entity
@Table(name = "clients")
@Getter
@Setter
public class User {

  @GeneratedValue
  private long id;
  private String username;
  private String email;
  private String password;
}
