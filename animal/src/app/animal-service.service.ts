import { Injectable } from '@angular/core';
import { HttpClient} from "@angular/common/http"
import { Observable } from 'rxjs';
import { HttpHeaders, HttpParams } from '@angular/common/http';
import { Animal } from './models/animal.model';



@Injectable({
  providedIn: 'root'
})
export class AnimalServiceService {
  readonly baseUrl: string = "https://localhost:8000";

  
  constructor(private http: HttpClient) { 

  }

  getAllAnimals(): Observable<any>{
    return this.http.get<any>(this.baseUrl + "/animals");
  }

  searchAnimals(min?:number, max?:number, type?:string): Observable<Animal[]> {
    console.log(`What I get on the service ${min} ${type}`)
    let httpParams = new HttpParams();
    if (min) httpParams = httpParams.append('min', min);      //payload
    if (max) httpParams = httpParams.append('max', max);      //payload
    if (type) httpParams = httpParams.append('type', type);      //payload

    const httpOptions = {
      params: httpParams
    };
    return this.http.get<Animal[]>(this.baseUrl + '/animals', httpOptions);
  }

  adoptAnimal(id?:number) {
    let httpParams = new HttpParams();
    if (id) httpParams = httpParams.append('id', id);      

    const httpOptions = {
      params: httpParams
    };
    return this.http.put<Animal[]>(this.baseUrl + '/animals', httpOptions);
  }
}

