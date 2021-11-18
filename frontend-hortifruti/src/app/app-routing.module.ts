import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './views/home/home/home.component';
import { RegisterProdComponent } from './views/products/register-prod/register-prod.component';
import { ConsultProdComponent } from './views/products/consult-prod/consult-prod.component';
import { RegisterCliComponent } from './views/clients/register-cli/register-cli.component';
import { ConsultCliComponent } from './views/clients/consult-cli/consult-cli.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "products-register",
    component: RegisterProdComponent
  },
  {
    path: "products-consult",
    component: ConsultProdComponent
  },
  {
    path: "clients-register",
    component: RegisterCliComponent
  },
  {
    path: "clients-consult",
    component: ConsultCliComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
