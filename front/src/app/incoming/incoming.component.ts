//
// Copyright 2020 Oleg Borodin  <borodin@unix7.org>
//

import { Component, OnInit } from '@angular/core'
import { FormGroup, FormControl, FormArray, FormBuilder, Validators } from '@angular/forms'
import { debounceTime, distinctUntilChanged, map } from 'rxjs/operators'

import { IncomingService, IncomingRequest, IncomingResponse, IncomingResult, Incoming } from '../incoming.service'

@Component({
    selector: 'incoming',
    templateUrl: './incoming.component.html',
    styleUrls: ['./incoming.component.scss']
})

export class IncomingComponent implements OnInit {

    searchForm: FormGroup

    noticeMessage: string = ""
    alertMessage: string = ""

    response: IncomingResponse

    result: IncomingResult = {
        limit: 0,
        offset: 0,
        total: 0,
        list: []
    }

    request: IncomingRequest = {
        limit:  5,
        offset: 0,
        pattern: ""
    }

    constructor(
        private formBuilder: FormBuilder,
        private incomingService: IncomingService
    ) {}

    list() {
        this.incomingService.list(this.request).subscribe(
            (response: IncomingResponse) => {
                //console.log(response)
                if (response.error == false) {
                    this.result = response.result
                } else {
                    if (response.message != null) {
                        this.alertMessage = "Backend error: " + response.message
                    } else {
                        this.alertMessage = "Backend error."
                    }
                }
            },
            (error) => {
                if (error.message != null) {
                    this.alertMessage = "Communication error: " + error.message
                } else {
                    this.alertMessage = "Communication error."
                }
            }
        )
    }

    setNewOffset(newOffset: any) {
        this.request.offset = newOffset
        this.list()
    }


    ngOnInit() {

        this.searchForm = this.formBuilder.group({
            pattern: [ "" ],
            limit: [ this.result.limit ],
        })

        this.list()

        this.searchForm.get('pattern').valueChanges
            .pipe(
                debounceTime(300),
                distinctUntilChanged()
            )
            .subscribe(value => {
                this.request.pattern = value
                this.list()
            })

        this.searchForm.get('limit').valueChanges
            .pipe(
                debounceTime(300),
                distinctUntilChanged()
            )
            .subscribe(value => {
                console.log(value)
                this.request.limit = value
                this.list()
            })

    }

}
