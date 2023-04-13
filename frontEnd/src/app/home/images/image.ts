export interface Image {
  Id: string
  ParentId: string
  RepoTags: string[]
  Size: number
  virtualSize: number
  Containers: number
  Created: number
}
