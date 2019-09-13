import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlanetsComponent } from './planets/planets.component';
import { HomeComponent } from './home/home.component';
import { StarsComponent } from './stars/stars.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'planets', component: PlanetsComponent},
  { path: 'stars', component: StarsComponent},
  { path: '**', pathMatch: 'full', redirectTo: 'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
