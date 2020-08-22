import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DocListComponent } from './doc-list/doc-list.component';


const routes: Routes = [
  { path: '', component: DocListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
