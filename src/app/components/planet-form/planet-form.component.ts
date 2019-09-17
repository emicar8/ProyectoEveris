import { Component, OnInit } from '@angular/core';
import { Planet } from 'src/app/models/planet';
import { PlanetService } from 'src/app/services/planet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Star } from 'src/app/models/star';
import { StarService } from 'src/app/services/star.service';

@Component({
  selector: 'app-planet-form',
  templateUrl: './planet-form.component.html',
  styleUrls: ['./planet-form.component.css']
})
export class PlanetFormComponent implements OnInit {

  planet : Planet = {
    id: null,
    name: null,
    size: null,
    star: null
  };

  stars : Star[] = [];

  nomElegido : string = null;

  constructor(private planetService : PlanetService, private starService : StarService, private activatedRoute : ActivatedRoute, private router : Router) { 
    this.activatedRoute.params.subscribe((data)=>{
      if(data.id != null){
        this.planetService.getOne(data.id).subscribe((data2)=>{
          this.planet = data2;
        });
      }
    });
    this.starService.getAll().subscribe((data)=>{
      this.stars = data;
    });
  }

  onClick(star : Star){
      this.planet.star = star;
      document.getElementById("front").innerHTML = star.name;
  }

  save(){
    if(this.planet.id != null){
      this.planetService.put(this.planet.id, this.planet).subscribe((data)=>{
        location.reload();
      });
    }else{
      this.planetService.post(this.planet).subscribe((data)=>{
        this.router.navigate(['/planets/' + data.id]);
      });
    }
  }

  ngOnInit() {
  }



}
