package ucode.servermatecontainers.images;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.model.Image;

import lombok.RequiredArgsConstructor;

/**
 * ImageController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/image")
public class ImageController {

  private final ImageService imageService;

  @GetMapping
  public ResponseEntity<List<Image>> getAllImages() {
    return ResponseEntity.ok(imageService.getAllImages());
  }

  @DeleteMapping("/{imageId}")
  public ResponseEntity<Void> deleteImage(@PathVariable String imageId) {
    imageService.deleteImage(imageId);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/prune")
  public ResponseEntity<Void> pruneImages(@PathVariable String imageId) {
    imageService.pruneImages();
    return ResponseEntity.ok().build();
  }

}
