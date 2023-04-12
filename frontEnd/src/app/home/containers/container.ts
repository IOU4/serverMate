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
  UKNOWN = "uknown"
}
