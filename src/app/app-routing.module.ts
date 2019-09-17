import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlanetsComponent } from './components/planets/planets.component';
import { HomeComponent } from './components/home/home.component';
import { StarsComponent } from './components/stars/stars.component';
import { StarFormComponent } from './components/star-form/star-form.component';
import { PlanetFormComponent } from './components/planet-form/planet-form.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'planets', component: PlanetsComponent},
  { path: 'planets/:id', component: PlanetFormComponent},
  { path: 'stars', component: StarsComponent},
  { path: 'stars/:id', component: StarFormComponent},
  { path: '**', pathMatch: 'full', redirectTo: 'home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
