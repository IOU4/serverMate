package ucode.servermatecontainers.images;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;

import lombok.RequiredArgsConstructor;

/**
 * ImageService
 */
@Service
@RequiredArgsConstructor
public class ImageService {

  private final DockerClient dockerClient;

  public List<Image> getAllImages() {
    return dockerClient.listImagesCmd().exec();
  }

}
