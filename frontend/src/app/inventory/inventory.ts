import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CommonModule,NgForOf} from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-inventory',
  imports: [CommonModule,HttpClientModule],
  templateUrl: './inventory.html',
  styleUrl: './inventory.css',
})
export class Inventory implements OnInit {
  products:any;
  constructor(private http : HttpClient) {
  }


  ngOnInit() {
    this.http.get('http://localhost:8888/inventory-service/products').subscribe(
      {
        next: (data: any) => {
          this.products = data._embedded.products;

        },
        error:(err: any)=>{
          console.log(err)
        }
      }
    );
}}
