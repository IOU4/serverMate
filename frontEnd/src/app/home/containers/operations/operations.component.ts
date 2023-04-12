import { Component, Input } from '@angular/core';
import { ContainersService } from '../containers.service';

@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html',
})
export class OperationsComponent {

  constructor(private containerService: ContainersService) { }

  // read container id from input
  @Input() containerId: string = '';

  loading: boolean = false;

  stop() {
    this.loading = true;
    this.containerService.stopContainer(this.containerId).subscribe({
      complete: () => {
        this.loading = false;
        console.log("container stopped");
        window.location.reload();
      }
    });
  }

  start() {
    this.loading = true;
    this.containerService.startContainer(this.containerId).subscribe({
      complete: () => {
        this.loading = false;
        console.log("container started");
        window.location.reload();
      }
    });
  }
  restart() {
    this.loading = true;
    this.containerService.restartContainer(this.containerId).subscribe({
      complete: () => {
        this.loading = false;
        console.log("container restarted");
        window.location.reload();
      }
    });
  }

  remove() {
    this.loading = true;
    this.containerService.deleteContainer(this.containerId).subscribe({
      complete: () => {
        this.loading = false;
        console.log("container removed");
        window.location.reload();
      }
    });
  }
}
