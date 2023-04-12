import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { authGuard } from '../auth.guard';
import { ContainerDetailsComponent } from './container-details/container-details.component';
import { ContainersListComponent } from './containers-list/containers-list.component';
import { ContainersComponent } from './containers.component';

const routes: Routes = [
  {
    path: '',
    canActivateChild: [authGuard],
    canActivate: [authGuard],
    component: ContainersComponent,
    children: [
      { path: '', redirectTo: '/containers', pathMatch: 'full' },
      { path: "containers", component: ContainersListComponent },
      { path: "containers/:id", component: ContainerDetailsComponent }
    ]
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContainersRoutingModule { }
