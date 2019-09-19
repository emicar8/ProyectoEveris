import { Component, OnInit } from '@angular/core';
import { Star } from 'src/app/models/star';
import { StarService } from 'src/app/services/star.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-star-form',
  templateUrl: './star-form.component.html',
  styleUrls: ['./star-form.component.css']
})
export class StarFormComponent implements OnInit {

  star: Star = {
    id: 0,
    name: null,
    density: null
  };

  starForm: FormGroup = this.formBuilder.group({
    starId: [{ value: null, disabled: true }],
    starName: [null, Validators.required],
    starDensity: [null, [Validators.required, Validators.pattern('^[0-9]*$')]]
  });

  constructor(private starService: StarService, private activatedRoute: ActivatedRoute,
    private router: Router, private formBuilder: FormBuilder) {

  }



  ngOnInit() {
    this.activatedRoute.params.subscribe((data) => {
      if (data.id != 0) {
        this.starService.getOne(data.id).subscribe((data2) => {
          this.star = data2;
          this.starForm.get("starId").setValue(this.star.id);
          this.starForm.get("starName").setValue(this.star.name);
          this.starForm.get("starDensity").setValue(this.star.density);
        })
      }
    })
  }

  onSubmit() {
    this.star.name = this.starForm.get("starName").value;
    this.star.density = this.starForm.get("starDensity").value;

    if (this.star.id != 0) {
      this.star.id = this.starForm.get("starId").value;
      this.starService.put(this.star.id, this.star).subscribe((data) => {
        location.reload();
      });
    } else {
      this.star.id = 0;
      this.starService.post(this.star).subscribe((data) => {
        this.router.navigate(['/stars/' + data.id]);
      });
    }
  }

  //Getters de los formControl utilizados. Se llaman implicitamente al utilizar .invalid, .dirty, .touched, etc.

  get starId() { return this.starForm.get("starId") }

  get starName() { return this.starForm.get("starName") }

  get starDensity() { return this.starForm.get("starDensity") }
}
