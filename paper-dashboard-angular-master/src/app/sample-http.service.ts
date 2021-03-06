import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { SampleModelList, svcModelList } from './sample.model';
import { bowlersList  } from './bowlers.model';
import { BaseResponse } from 'app/shared/shared.model';

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

  getBowlerList(): Observable<bowlersList> {
    const href = '/sample/getBowlerList';
    const requestUrl =
          `${href}`;
    return this._httpClient.get<bowlersList>(requestUrl);
  }
  

  saveSvc(newData: any): Observable<BaseResponse> {
    const href = '/sample';
    const requestUrl =
          `${href}/saveSvc`;
    return this._httpClient.post<BaseResponse>(requestUrl, newData);
  }

}
