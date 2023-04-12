export interface Container {
  id: string
  command: string
  created: Date
  image: string
  names: string[]
  state: ContainerState
  status: string
}

export enum ContainerState {
  RUNNING = "running",
  PAUSED = "paused",
  RESTARTING = "restarting",
  DEAD = "dead",
  UKNOWN = "uknown",
  EXITED = "exited"
}

export interface ContainerResponse {
  Id: string
  Names: string[]
  Command: string
  Created: number
  Image: string
  ImageID: string
  Status: string
  State: string
  Ports: Port[]
  Mounts: Mount[]
  HostConfig: {
    NetworkMode: string
  }
}

export interface Port {
  IP: string
  PublicPort: number
  PrivatePort: number
  Type: string
}

export interface Mount {
  Type: string
  Name: string
  Source: string
  Destination: string
  driver: string
  Mode: string
}

export interface ConttainerLog {
  log: string
}
