package ucode.servermatecontainers.volumes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.command.ListVolumesResponse;

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
  public ResponseEntity<ListVolumesResponse> getAllvolumes() {
    return ResponseEntity.ok(volumeService.getAllVolumes());
  }

}
