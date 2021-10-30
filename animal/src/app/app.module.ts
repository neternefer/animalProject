import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnimalComponent } from './animal/animal.component';
import { AdopterComponent } from './adopter/adopter.component';

@NgModule({
  declarations: [
    AppComponent,
    AnimalComponent,
    AdopterComponent,
    AnimalComponent,
    AdopterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
