import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FAQComponent } from './faq/faq.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { ExtraRoutingModule } from './extra-routing.module';
import { ExtraComponent } from './extra.component';
import { SharedModule } from '../shared/shared.module';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';



@NgModule({
  declarations: [
    FAQComponent,
    AboutComponent,
    ContactComponent,
    ExtraComponent,
    PageNotFoundComponent
  ],
  imports: [
    CommonModule,
    ExtraRoutingModule,
    SharedModule
  ]
})
export class ExtraModule { }
