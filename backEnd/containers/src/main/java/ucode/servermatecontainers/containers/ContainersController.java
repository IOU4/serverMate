package ucode.servermatecontainers.containers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.model.Container;

import lombok.RequiredArgsConstructor;
import ucode.servermatecontainers.model.ContainerLogResponse;
import ucode.servermatecontainers.model.SuccessResponse;

/**
 * ContainersController
 */
@RestController
@RequestMapping("/api/v1/container")
@RequiredArgsConstructor
public class ContainersController {

  private final ContainersService containersService;

  @GetMapping
  public ResponseEntity<List<Container>> getAllContainers() {
    return ResponseEntity.ok(containersService.getAllContaieners());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Container> getSingelContainer(@PathVariable("id") String id) {
    return ResponseEntity.ok(containersService.findContainer(id));
  }

  @GetMapping("/{id}/stop")
  public ResponseEntity<SuccessResponse> stopContainer(@PathVariable("id") String containerId) {
    return ResponseEntity.ok(containersService.stopContainer(containerId));
  }

  @GetMapping("/{id}/start")
  public ResponseEntity<SuccessResponse> startContainer(@PathVariable("id") String containerId) {
    return ResponseEntity.ok(containersService.startContainer(containerId));
  }

  @GetMapping("/{id}/restart")
  public ResponseEntity<SuccessResponse> restartContainer(@PathVariable("id") String containerId) {
    return ResponseEntity.ok(containersService.restartContainer(containerId));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<SuccessResponse> removeContainer(@PathVariable("id") String containerId) {
    return ResponseEntity.ok(containersService.removeContainer(containerId));
  }

  @GetMapping("/{id}/logs")
  public ResponseEntity<ContainerLogResponse> logContainer(@PathVariable("id") String containerId) {
    return ResponseEntity.ok(containersService.getContainerLogs(containerId));
  }
}
