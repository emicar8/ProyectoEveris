import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Planet } from '../models/planet';

@Injectable({
  providedIn: 'root'
})
export class PlanetsService {

  private URL : string = "http://localhost:8080/api/v1/planets";

  constructor(private http : HttpClient) { }

  getOne(id : number) : Observable<Planet>{
    return this.http.get<Planet>(this.URL + id);
  }

  getAll(id : number) : Observable<Planet[]>{
    return this.http.get<Planet[]>(this.URL);
  }

  post(planet : Planet) : Observable<Planet> {
    return this.http.post<Planet>(this.URL, planet);
  }

  put(id : number, planet : Planet) : Observable<Planet> {
    return this.http.put<Planet>(this.URL + id, planet);
  }

  delete(id : number){
    this.http.delete(this.URL + id);
  }
}
