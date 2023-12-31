import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ReservationsComponent} from "./reservations/reservations.component";
import {ResourcesComponent} from "./resources/resources.component";
import {PersonsComponent} from "./persons/persons.component";


const routes: Routes = [
  { path : "reservations", component : ReservationsComponent},
  { path : "resources", component : ResourcesComponent , //canActivate:[AuthGuard], data : { roles:['USER'] }
  },{ path : "persons", component : PersonsComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
