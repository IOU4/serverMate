import { Component, OnInit } from '@angular/core';
import { Container, ContainerState } from '../container';
import { ContainersService } from '../containers.service';

@Component({
  selector: 'app-containers-list',
  templateUrl: './containers-list.component.html',
})
export class ContainersListComponent implements OnInit {

  constructor(private containerService: ContainersService) { }

  containers: Container[] = []
  ngOnInit(): void {
    this.containerService.getContainers().subscribe({
      next: (data) => {
        data.forEach(item => {
          let state = ContainerState.UKNOWN
          switch (item.State) {
            case "running": state = ContainerState.RUNNING
              break;
            case "dead": state = ContainerState.DEAD
              break;
            case "paused": state = ContainerState.PAUSED
              break;
            case "restarting": state = ContainerState.RESTARTING
              break;
            default: state = ContainerState.UKNOWN
          }
          this.containers.push({
            id: item.Id,
            command: item.Command,
            created: new Date(item.Created),
            image: item.Image,
            names: item.Names,
            state: state,
            status: item.Status,
          })
        })

      },
      error: () => { },
      complete: () => { }
    })
  }
}
