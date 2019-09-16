import { Component, OnInit } from '@angular/core';
import { Star } from 'src/app/models/star';
import { StarService } from 'src/app/services/star.service';

@Component({
  selector: 'app-stars',
  templateUrl: './stars.component.html',
  styleUrls: ['./stars.component.css']
})
export class StarsComponent implements OnInit {

  stars : Star[] = [];

  constructor(private starService : StarService) { }

  ngOnInit() {
    this.starService.getAll().subscribe((data)=>{
      this.stars = data;
    })
  }

}
