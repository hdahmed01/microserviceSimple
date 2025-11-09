import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CommonModule,NgForOf} from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-customer',
  imports: [HttpClientModule,CommonModule],
  templateUrl: './customer.html',
  styleUrl: './customer.css',
})
export class Customer implements OnInit {
  customers:any;
  constructor(private http : HttpClient) {
  }


  ngOnInit() {
    this.http.get('http://localhost:8888/customer-service/customers').subscribe(
      {
        next: (data: any) => {
          this.customers = data._embedded.customers;
          console.log(this.customers)//
        },
        error:(err: any)=>{
          console.log(err)
        }
      }
    );
  }

}
