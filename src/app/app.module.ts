import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './components/shared/menu/menu.component';
import { PlanetsComponent } from './components/planets/planets.component';
import { HomeComponent } from './components/home/home.component';
import { StarsComponent } from './components/stars/stars.component';
import { StarFormComponent } from './components/star-form/star-form.component';
import { PlanetFormComponent } from './components/planet-form/planet-form.component';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    PlanetsComponent,
    HomeComponent,
    StarsComponent,
    StarFormComponent,
    PlanetFormComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
