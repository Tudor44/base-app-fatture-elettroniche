import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FattureListaComponent } from './fatture-lista/fatture-lista.component';

export const routes: Routes = [
  { path: '', redirectTo: '/fatture', pathMatch: 'full' },
  {
    path: 'fatture',
    component: FattureListaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
