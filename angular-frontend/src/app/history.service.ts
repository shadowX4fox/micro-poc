import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, filter, switchMap, catchError } from 'rxjs/operators';
import { BASE_URL } from './const';
import { History } from './editor/history';
import { Response } from '@angular/http';


@Injectable({
  providedIn: 'root'
})
export class HistoryService {

  private historyUrl = ''

  constructor(private http: HttpClient, @Inject(BASE_URL) private baseUrl: string) { this.historyUrl = this.baseUrl }

  getHistory(tag:string) : Observable<History[]>
  {
    const url = `${this.historyUrl}/lastOperations`;
    // Initialize Params Object
    let params = new HttpParams();

    // Begin assigning parameters
    params = params.append('tag', tag);    

    return this.http.get(url,{params : params}).pipe(map(
      (resp:Object[]) => {
        //var jsonResponse = resp.json().results; 
        console.log(resp);
        var res : History[] = [];
        
        for (let entry of resp) {
          var h : History;
          var event = entry["event"];
          h = {
            record: event["order"],
            tag: event["name"],
            operation: event["operation"],
            value1: event["value1"],
            value2: event["value2"]
          }
          res.push(h);          
        }        
        return res;
      }
      ),catchError(null));    
  } 

}
