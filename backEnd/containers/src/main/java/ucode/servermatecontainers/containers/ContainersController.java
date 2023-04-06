package ucode.servermatecontainers.containers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.model.Container;

import lombok.RequiredArgsConstructor;

/**
 * ContainersController
 */
@RestController
@RequestMapping("/containers")
@RequiredArgsConstructor
public class ContainersController {

  private final ContainersService containersService;

  @GetMapping
  public ResponseEntity<List<Container>> getAllContainers() {
    return ResponseEntity.ok(containersService.getAllContaieners());
  }
}
