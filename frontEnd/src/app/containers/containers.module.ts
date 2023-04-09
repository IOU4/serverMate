import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContainersRoutingModule } from './containers-routing.module';
import { HomeComponent } from './home/home.component';
import { SharedModule } from '../shared/shared.module';
import { ContainerDetailsComponent } from './container-details/container-details.component';
import { ContainersComponent } from './containers/containers.component';


@NgModule({
  declarations: [
    HomeComponent,
    ContainerDetailsComponent,
    ContainersComponent
  ],
  imports: [
    CommonModule,
    ContainersRoutingModule,
    SharedModule
  ]
})
export class ContainersModule { }
