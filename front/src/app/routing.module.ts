//
// Copyright 2020 Oleg Borodin  <borodin@unix7.org>
//

import { NgModule } from '@angular/core'
import { Routes, RouterModule } from '@angular/router'

import { HomeComponent } from './home/home.component'
import { NotFoundComponent } from './not-found/not-found.component'
import { PageGuard } from './page.guard'

export const routes: Routes = [
    { path: "", component: HomeComponent, canActivate: [PageGuard],  data: { name: "Home" } },
    { path: "notfound", component: NotFoundComponent, canActivate: [PageGuard] },
    { path: "**", component: NotFoundComponent, canActivate: [PageGuard] },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class RoutingModule { }
