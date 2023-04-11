package ucode.servermatecontainers.images;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.PruneType;

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

  public Image getImage(String imageId) {
    return dockerClient.listImagesCmd().withImageNameFilter(imageId).exec().get(0);
  }

  public void deleteImage(String imageId) {
    dockerClient.removeImageCmd(imageId).exec();
  }

  public void pruneImages() {
    dockerClient.pruneCmd(PruneType.IMAGES).exec();
  }

}
