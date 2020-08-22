import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CurrencyService } from './../service/currency.service';
import { DocService } from './../service/doc.service';
import { Currency } from './../model/Currency';
import { Doc } from './../model/Doc';

@Component({
  selector: 'app-doc-list',
  templateUrl: './doc-list.component.html',
  styleUrls: ['./doc-list.component.css']
})
export class DocListComponent implements OnInit {

  currencies: Observable<Currency[]>;
  docs: Observable<Doc[]>;

  documentNumber: string;
  currencyCode: string;
  startDate: string;
  endDate: string;

  constructor(private currencyService: CurrencyService,
              private docService: DocService ) { }

  ngOnInit(): void {
    this.loadPage();
  }

  loadPage() {
    this.currencies = this.currencyService.getCurrencies();
  }

  searchDocs() {
    this.docs = this.docService.search(this.documentNumber, this.currencyCode, this.startDate, this.endDate);
  }

}
