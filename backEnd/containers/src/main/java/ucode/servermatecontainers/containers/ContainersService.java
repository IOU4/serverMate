package ucode.servermatecontainers.containers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;

import lombok.RequiredArgsConstructor;

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
}
