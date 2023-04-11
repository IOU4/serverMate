import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';
import { ContainersModule } from './containers/containers.module';


@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    ContainersModule
  ]
})
export class HomeModule { }
