import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface Incoming {
    id?:                number
    agentId?:           number
    agentName?:         string
    divisionId?:        number
    divisionName?:      string
    value?:             number
}

export interface IncomingRequest {
    offset:     number
    limit:      number
    pattern:    string
}

export interface IncomingResult {
    offset:     number
    limit:      number
    total:      number
    list:       Incoming[]
}

export interface IncomingResponse {
    error:     boolean
    message:   string
    result:    IncomingResult
}


@Injectable({
    providedIn: 'root'
})

export class IncomingService {

    constructor(private httpClient: HttpClient) {}

    list(request: IncomingRequest) {
        return this.httpClient.post<IncomingResponse>(`/api/v1/incoming/list`, {
            "limit":    request.limit,
            "offset":   request.offset,
            "pattern":  request.pattern
        })
    }

}
