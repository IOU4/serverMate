package ucode.servermatecontainers.containers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;

import lombok.RequiredArgsConstructor;
import ucode.servermatecontainers.exceptions.ContainerNotFoundException;

/**
 * ContainersService
 */
@Service
@RequiredArgsConstructor
public class ContainersService {

  private final DockerClient dockerClient;

  public List<Container> getAllContaieners() {
    return dockerClient.listContainersCmd().exec();
  }

  public Container findContainer(String id) {
    var container = dockerClient.listContainersCmd().exec()
        .stream()
        .filter(c -> c.getId().equals(id))
        .findFirst();
    if (!container.isPresent())
      throw new ContainerNotFoundException(id);
    return container.get();
  }
}
