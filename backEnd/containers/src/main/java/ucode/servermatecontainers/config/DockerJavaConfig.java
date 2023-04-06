package ucode.servermatecontainers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.transport.DockerHttpClient;
import com.github.dockerjava.zerodep.ZerodepDockerHttpClient;

/**
 * DockerJavaConfig
 */
@Configuration
public class DockerJavaConfig {

  private DockerClientConfig dockerClientConfig() {
    return DefaultDockerClientConfig.createDefaultConfigBuilder()
        .withDockerHost("unix:///run/docker.sock")
        .build();
  }

  private DockerHttpClient dockerHttpClient() {
    return new ZerodepDockerHttpClient.Builder()
        .dockerHost(dockerClientConfig().getDockerHost())
        .build();
  }

  @Bean
  public DockerClient dockerClient() {
    return DockerClientImpl.getInstance(dockerClientConfig(), dockerHttpClient());
  }
}
