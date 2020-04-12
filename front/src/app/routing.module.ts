//
// Copyright 2020 Oleg Borodin  <borodin@unix7.org>
//

import { NgModule } from '@angular/core'
import { Routes, RouterModule } from '@angular/router'

import { IncomingComponent } from './incoming/incoming.component'
import { NotFoundComponent } from './not-found/not-found.component'
import { PageGuard } from './page.guard'

export const routes: Routes = [
    { path: "", component: IncomingComponent, canActivate: [PageGuard],  data: { name: "Incoming" } },
    { path: "notfound", component: NotFoundComponent, canActivate: [PageGuard] },
    { path: "**", component: NotFoundComponent, canActivate: [PageGuard] },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class RoutingModule { }
