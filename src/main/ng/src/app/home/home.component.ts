import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  template: `
    <section>
      <img src="/a/assets/angular.svg" class="logo" alt="Angular">
      <h1> Java + Angular</h1>
      <button type="button" (click)="increment()">count is {{counterValue }}</button>
      <p>edit <code>home.component.ts</code> </p>
    </section>
  `,
  styleUrls: ['./home.component.css'],
  
})
export class HomeComponent {
	counterValue = 0;
	increment() {this.counterValue++;}

}
