import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContainersRoutingModule } from './containers-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { ContainersListComponent } from './containers-list/containers-list.component';
import { ContainerDetailsComponent } from './container-details/container-details.component';
import { ContainersComponent } from './containers.component';
import { OperationsComponent } from './operations/operations.component';
import { TruncateStringPipe } from '../truncate-string.pipe';

@NgModule({
  declarations: [
    ContainersListComponent,
    ContainerDetailsComponent,
    ContainersComponent,
    OperationsComponent
  ],
  imports: [
    CommonModule,
    ContainersRoutingModule,
    SharedModule,
    TruncateStringPipe
  ]
})
export class ContainersModule { }
