import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CommonModule, NgForOf} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-billing',
  standalone: true,
  imports: [HttpClientModule, CommonModule, RouterLink],
  templateUrl: './billing.html',
  styleUrl: './billing.css'
})
export class Billing implements OnInit {

  bills: any[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8888/billing-service/bills').subscribe({
      next: (data: any) => {
        this.bills = data._embedded.bills;
        console.log(this.bills);
      },
      error: (err) => console.error(err)
    });
  }
}
