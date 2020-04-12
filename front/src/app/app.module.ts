//
// Copyright 2020 Oleg Borodin  <borodin@unix7.org>
//

import { BrowserModule } from '@angular/platform-browser'
import { NgModule } from '@angular/core'

import { HashLocationStrategy, LocationStrategy } from '@angular/common'

import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http'

import { RoutingModule } from './routing.module'
import { AppComponent } from './app.component'
import { LayoutComponent } from './layout/layout.component'
import { MenuComponent } from './menu/menu.component'

import { IncomingComponent } from './incoming/incoming.component'
import { NotFoundComponent } from './not-found/not-found.component';

import { PagerComponent } from './pager/pager.component';

@NgModule({
    declarations: [
        AppComponent,
        LayoutComponent,
        MenuComponent,
        NotFoundComponent,
        IncomingComponent,
        PagerComponent,
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        RoutingModule,
        ReactiveFormsModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
