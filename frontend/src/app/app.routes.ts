import { Routes } from '@angular/router';
import {Customer} from './customer/customer';
import {Inventory} from './inventory/inventory';
import {Billing} from './billing/billing';
import {BillDetails} from './bill-details/bill-details';

export const routes: Routes = [
  {path  : "customers",component:Customer},
  {path  : "inventory",component:Inventory},
  {path  : "bills",component:Billing},
  { path: 'bills/:id', component: BillDetails },
];
