import { Component, OnInit } from '@angular/core';
import { Animal } from '../models/animal.model';

@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.css']
})
export class AnimalComponent implements OnInit {
  animalList:Array<Animal>;
  constructor() { 
    this.animalList = [];
  }

  ngOnInit(): void {
  }

}
