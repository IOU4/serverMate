import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

interface ContainerResponse {
  Id: string
  Names: string[]
  Command: string
  Created: number
  Image: string
  ImageID: string
  Status: string
  State: string
}
@Injectable({
  providedIn: 'root'
})
export class ContainersService {

  constructor(private http: HttpClient) { }
  private baseApiUrl = "http://localhost:8080/api/v1"

  getContainers() {
    return this.http.get<ContainerResponse[]>(this.baseApiUrl + "/container");
  }
}
