import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { SampleModelList, svcModelList } from './sample.model';

@Injectable({
  providedIn: 'root'
})
export class SampleHttpService {

  constructor(
    private _httpClient: HttpClient
  ) {}

  getSampleList(plcyId : string): Observable<SampleModelList> {
    const href = '/sample/getSampleList';
    const requestUrl =
          `${href}?plcyId=${plcyId}`;
    return this._httpClient.get<SampleModelList>(requestUrl);
  }
  
  getSvcList(mdlYear : string): Observable<svcModelList> {
    const href = '/sample/getSvcList';
    const requestUrl =
          `${href}?mdlYear=${mdlYear}`;
    return this._httpClient.get<svcModelList>(requestUrl);
  }



}
