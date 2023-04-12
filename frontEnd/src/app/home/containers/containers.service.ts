import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ContainerResponse, ConttainerLog } from './container';

@Injectable({
  providedIn: 'root'
})
export class ContainersService {

  constructor(private http: HttpClient) { }
  private baseApiUrl = "http://localhost:8080/api/v1"

  getContainers() {
    return this.http.get<ContainerResponse[]>(`${this.baseApiUrl}/container`);
  }

  getContainerDetails(containerId: string) {
    return this.http.get<ContainerResponse>(`${this.baseApiUrl}/container/${containerId}`);
  }

  getContainerLogs(containerId: string) {
    return this.http.get<ConttainerLog>(`${this.baseApiUrl}/container/${containerId}/logs`);
  }

  stopContainer(containerId: string) {
    return this.http.get(`${this.baseApiUrl}/container/${containerId}/stop`);
  }

  startContainer(containerId: string) {
    return this.http.get(`${this.baseApiUrl}/container/${containerId}/start`);
  }

  restartContainer(containerId: string) {
    return this.http.get(`${this.baseApiUrl}/container/${containerId}/restart`);
  }

  deleteContainer(containerId: string) {
    return this.http.delete(`${this.baseApiUrl}/container/${containerId}`);
  }

  pruneContainers() {
    return this.http.get(`${this.baseApiUrl}/container/prune`);
  }
}
