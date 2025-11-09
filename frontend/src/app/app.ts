import { Component, signal } from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
