import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ImagesRoutingModule } from './images-routing.module';
import { ImagesComponent } from './images.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { TruncateStringPipe } from '../truncate-string.pipe';


@NgModule({
  declarations: [
    ImagesComponent,
  ],
  imports: [
    CommonModule,
    ImagesRoutingModule,
    SharedModule,
    TruncateStringPipe
  ]
})
export class ImagesModule { }
