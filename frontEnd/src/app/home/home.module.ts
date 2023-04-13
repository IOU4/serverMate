import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';
import { ContainersModule } from './containers/containers.module';
import { ImagesModule } from './images/images.module';


@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    ContainersModule,
    ImagesModule
  ]
})
export class HomeModule { }
