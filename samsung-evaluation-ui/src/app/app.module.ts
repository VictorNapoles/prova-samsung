import { Doc } from './model/Doc';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxMaskModule, IConfig } from 'ngx-mask'


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DocListComponent } from './doc-list/doc-list.component';
import { CurrencyService } from './service/currency.service';
import { DocService } from './service/doc.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

const maskConfig: Partial<IConfig> = {
  validation: false,
};

@NgModule({
  declarations: [
    AppComponent,
    DocListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgxMaskModule.forRoot(maskConfig),
    BrowserAnimationsModule
  ],
  providers: [
    CurrencyService,
    DocService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
