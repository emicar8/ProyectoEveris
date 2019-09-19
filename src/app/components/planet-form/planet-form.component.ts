import { Component, OnInit } from '@angular/core';
import { Planet } from 'src/app/models/planet';
import { PlanetService } from 'src/app/services/planet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Star } from 'src/app/models/star';
import { StarService } from 'src/app/services/star.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-planet-form',
  templateUrl: './planet-form.component.html',
  styleUrls: ['./planet-form.component.css']
})
export class PlanetFormComponent implements OnInit {

  planet: Planet = {
    id: 0,
    name: null,
    size: null,
    star: null
  };

  stars: Star[] = [];

  planetForm: FormGroup = this.formBuilder.group({
    planetId: [{ value: null, disabled: true }],
    planetName: [null, Validators.required],
    planetSize: [null, [Validators.required, Validators.pattern('^[0-9]*$')]],
    planetStar: [null, Validators.required]
  });

  constructor(private planetService: PlanetService, private starService: StarService, 
    private activatedRoute: ActivatedRoute, private router: Router, private formBuilder: FormBuilder) {

  }

  ngOnInit() {
    this.activatedRoute.params.subscribe((data) => {
      if (data.id != 0) {
        this.planetService.getOne(data.id).subscribe((data2) => {
          this.planet = data2;
          this.planetForm.get("planetId").setValue(this.planet.id);
          this.planetForm.get("planetName").setValue(this.planet.name);
          this.planetForm.get("planetSize").setValue(this.planet.size);
          this.planetForm.get("planetStar").setValue(this.planet.star.id);
        });
      }
    });

    this.starService.getAll().subscribe((data) => {
      this.stars = data;
    });

  }

  onSubmit() {

    //Seguro hay una forma mejor de hacer esto.

    this.planet.name = this.planetForm.get("planetName").value;
    this.planet.size = this.planetForm.get("planetSize").value;
    this.planet.star = this.stars[this.planetForm.get("planetStar").value - 1];

    if (this.planet.id != 0) {
      this.planet.id = this.planetForm.get("planetId").value;
      this.planetService.put(this.planet.id, this.planet).subscribe((data) => {
        location.reload();
      });
    } else {
      this.planet.id = 0; //Evitar enviar id null.
      this.planetService.post(this.planet).subscribe((data) => {
        this.router.navigate(['/planets/' + data.id]);
      });
    }
  }


  //Getters de los formControl utilizados. Se llaman implicitamente al utilizar .invalid, .dirty, .touched, etc.

  get planetId() { return this.planetForm.get("planetId") }

  get planetName() { return this.planetForm.get("planetName") }

  get planetSize() { return this.planetForm.get("planetSize") }

  get planetStar() { return this.planetForm.get("planetStar") }
}  
