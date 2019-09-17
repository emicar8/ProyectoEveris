import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Star } from '../models/star';

@Injectable({
  providedIn: 'root'
})
export class StarService {

  private URL:string = "http://localhost:8080/api/v1/stars/";

  constructor(private http:HttpClient) { }

  getOne(id:number) : Observable<Star>{
    return this.http.get<Star>(this.URL + id);
  }

  getAll() : Observable<Star[]>{
    return this.http.get<Star[]>(this.URL);
  }

  post(star : Star) : Observable<Star>{
    return this.http.post<Star>(this.URL, star);
  }

  put(id : number, star : Star) : Observable<Star>{
    return this.http.put<Star>(this.URL + id, star);
  }

  delete(id : number) : Observable<any>{
    return this.http.delete(this.URL + id);
  }
}
