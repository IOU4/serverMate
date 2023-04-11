package ucode.servermatecontainers.networks;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Network;
import com.github.dockerjava.api.model.PruneType;

import lombok.RequiredArgsConstructor;

/**
 * NetworkService
 */
@Service
@RequiredArgsConstructor
public class NetworkService {

  private final DockerClient dockerClient;

  public List<Network> getAllNetworks() {
    return dockerClient.listNetworksCmd().exec();
  }

  public Network getNetwork(String networkId) {
    return dockerClient.listNetworksCmd().withIdFilter(networkId).exec().get(0);
  }

  public void removeNetwork(String networkId) {
    dockerClient.removeNetworkCmd(networkId).exec();
  }

  public void pruneNetworks() {
    dockerClient.pruneCmd(PruneType.NETWORKS).exec();
  }
}
