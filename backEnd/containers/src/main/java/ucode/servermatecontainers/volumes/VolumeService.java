package ucode.servermatecontainers.volumes;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.ListVolumesResponse;

import lombok.RequiredArgsConstructor;

/**
 * VolumeService
 */
@Service
@RequiredArgsConstructor
public class VolumeService {

  private final DockerClient dockerClient;

  public ListVolumesResponse getAllVolumes() {
    return dockerClient.listVolumesCmd().exec();
  }

}
