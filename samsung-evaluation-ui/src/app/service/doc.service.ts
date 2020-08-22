import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DocService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  search(documentNumber: string, currencyCode: string, startDate: string, endDate: string): Observable<any> {
    let query = '?a';
    if (documentNumber) {
      query += `&documentNumber=${documentNumber}`;
    }

    if (currencyCode) {
      query += `&currencyCode=${currencyCode}`;
    }

    if (startDate) {
      query += `&startDate=${startDate}`;
    }

    if (endDate) {
      query += `&endDate=${endDate}`;
    }

    return this.http.get(`${this.baseUrl}/docs/search${query}`);
  }

}
