import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ContainerResponse } from '../container';
import { ContainersService } from '../containers.service';

@Component({
  selector: 'app-container-details',
  templateUrl: './container-details.component.html',
})
export class ContainerDetailsComponent implements OnInit {
  constructor(private containerService: ContainersService, private route: ActivatedRoute) { }

  container: ContainerResponse = {
    Id: '',
    Names: [],
    Command: '',
    Created: 0,
    Image: '',
    ImageID: '',
    Status: '',
    State: '',
    Ports: [],
    Mounts: [],
    HostConfig: {
      NetworkMode: ''
    }
  };
  log: string = ''
  ngOnInit(): void {
    const containerId = this.route.snapshot.paramMap.get('id')!;
    this.containerService.getContainerDetails(containerId).subscribe(container => {
      this.container = container;
    });
    this.containerService.getContainerLogs(containerId).subscribe(log => {
      this.log = log.log;
    })
  }
}
