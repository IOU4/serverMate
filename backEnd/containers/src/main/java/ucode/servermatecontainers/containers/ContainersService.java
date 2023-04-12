package ucode.servermatecontainers.containers;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Frame;

import lombok.RequiredArgsConstructor;
import ucode.servermatecontainers.model.ContainerLogResponse;
import ucode.servermatecontainers.model.SuccessResponse;

/**
 * ContainersService
 */
@Service
@RequiredArgsConstructor
public class ContainersService {

  private final DockerClient dockerClient;

  public List<Container> getAllContaieners() {
    return dockerClient.listContainersCmd().withShowAll(true).exec();
  }

  public Container findContainer(String id) {
    return dockerClient.listContainersCmd()
        .withShowAll(true)
        .withIdFilter(Collections.singleton(id))
        .exec().get(0);
  }

  // stop container
  public SuccessResponse stopContainer(String containerId) {
    dockerClient.stopContainerCmd(containerId).exec();
    return new SuccessResponse("container stopped successfully", HttpStatus.OK);
  }

  // start container
  public SuccessResponse startContainer(String containerId) {
    dockerClient.startContainerCmd(containerId).exec();
    return new SuccessResponse("container started successfully", HttpStatus.OK);
  }

  // remove container
  public SuccessResponse removeContainer(String containerId) {
    dockerClient.removeContainerCmd(containerId).exec();
    return new SuccessResponse("container removed successfully", HttpStatus.OK);
  }

  // restart container
  public SuccessResponse restartContainer(String containerId) {
    dockerClient.restartContainerCmd(containerId).exec();
    return new SuccessResponse("container restarted successfully", HttpStatus.OK);
  }

  // get contianer logs
  public ContainerLogResponse getContainerLogs(String containerId) {
    var containerLog = new StringBuilder();
    var resultCallback = new ResultCallback.Adapter<Frame>() {
      @Override
      public void onNext(Frame frame) {
        containerLog.append(new String(frame.getPayload()));
      }
    };
    try {
      dockerClient.logContainerCmd(containerId).withStdOut(true).exec(resultCallback).awaitCompletion();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return new ContainerLogResponse(containerLog.toString());
  }

}
