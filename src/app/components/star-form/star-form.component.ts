import { Component, OnInit } from '@angular/core';
import { Star } from 'src/app/models/star';
import { StarService } from 'src/app/services/star.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-star-form',
  templateUrl: './star-form.component.html',
  styleUrls: ['./star-form.component.css']
})
export class StarFormComponent implements OnInit {

  star: Star = {
    id: null,
    name: null,
    density: null
  };

  constructor(private starService: StarService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.params.subscribe((data) => {
      if (data.id != null) {
        this.starService.getOne(data.id).subscribe((data2) => {
          this.star = data2;
        })
      }
    })
  }

  save() {
    if (this.star.id != null) {
      this.starService.put(this.star.id,this.star).subscribe((data)=>{
        location.reload();
      });
    }else {
      this.starService.post(this.star).subscribe((data)=>{
        this.router.navigate(['/stars/'+ data.id]);
      });
    }
  }

  ngOnInit() {
  }

}
