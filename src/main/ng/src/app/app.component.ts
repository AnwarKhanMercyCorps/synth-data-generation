import {Component} from '@angular/core';
import {HomeComponent} from './home/home.component';
import {HeaderComponent} from './shared/header.component';
import {FooterComponent} from './shared/footer.component';
import {NavComponent} from './shared/nav.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HomeComponent,HeaderComponent,FooterComponent,NavComponent],
  templateUrl: './app.component.html',
  
})
export class AppComponent {
  title = 'default';
}
