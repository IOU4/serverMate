package ucode.servermatecontainers.volumes;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.command.InspectVolumeResponse;

import lombok.RequiredArgsConstructor;

/**
 * volumeController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/volume")
public class VolumeController {

  private final VolumeService volumeService;

  @GetMapping
  public ResponseEntity<List<InspectVolumeResponse>> getAllvolumes() {
    return ResponseEntity.ok(volumeService.getAllVolumes());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteVolume(@PathVariable("id") String id) {
    volumeService.removeVolume(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/prune")
  public ResponseEntity<Void> pruneVolumes(@PathVariable("id") String id) {
    volumeService.pruneVolumes();
    return ResponseEntity.ok().build();
  }
}
