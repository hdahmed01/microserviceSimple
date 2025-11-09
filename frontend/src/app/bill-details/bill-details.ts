import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bill-details',
  standalone: true,
  imports: [HttpClientModule, CommonModule],
  templateUrl: './bill-details.html',
  styleUrl: './bill-details.css'
})
export class BillDetails implements OnInit {

  bill: any = null;

  constructor(
    private http: HttpClient,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const billId = this.route.snapshot.paramMap.get('id');
    this.http.get(`http://localhost:8888/billing-service/bills/${billId}`).subscribe({
      next: (data: any) => this.bill = data,
      error: err => console.error(err)
    });
  }

  getTotal() {
    if (!this.bill || !this.bill.productItems) return 0;
    return this.bill.productItems.reduce((sum: number, item: any) => sum + (item.quantity * item.unitPrice), 0);
  }
}
