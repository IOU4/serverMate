package ucode.servermatecontainers.exceptions;

public class ContainerNotFoundException extends RuntimeException {

  public ContainerNotFoundException(String id) {
    super("container with id: '" + id + "' not found");
  }
}
