import { Injectable, Inject } from '@angular/core';
import { Editor } from './editor/editor';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, filter, switchMap, catchError } from 'rxjs/operators';
import { BASE_URL } from './const';


@Injectable({
  providedIn: 'root'
})
export class CalculateService {

  private calcUrl = ''

  constructor(private http: HttpClient, @Inject(BASE_URL) private baseUrl: string) { this.calcUrl = this.baseUrl }

  add(tagValue:string,value1Value:number,value2Value:number): Observable<Editor>{
    const url = `${this.calcUrl}/add`;
    // Initialize Params Object
    let params = new HttpParams();

    // Begin assigning parameters
    params = params.append('tag', tagValue);
    params = params.append('value1', value1Value.toString());
    params = params.append('value2', value2Value.toString());
    
    

    return this.http.get(url,{params : params}).pipe(map(
      (resp:number) => {
        var res: Editor;
        res = {
          tag: tagValue,
          value1: value1Value,
          value2: value2Value,
          lastOp: "add",
          result: resp
        }
        return res;
      }
      ),catchError(null));    
  }

  subtract(tagValue:string,value1Value:number,value2Value:number): Observable<Editor>{
    const url = `${this.calcUrl}/subtract`;
    // Initialize Params Object
    let params = new HttpParams();

    // Begin assigning parameters
    params = params.append('tag', tagValue);
    params = params.append('value1', value1Value.toString());
    params = params.append('value2', value2Value.toString());
    
    

    return this.http.get(url,{params : params}).pipe(map(
      (resp:number) => {
        var res: Editor;
        res = {
          tag: tagValue,
          value1: value1Value,
          value2: value2Value,
          lastOp: "subtract",
          result: resp
        }
        return res;
      }
      ),catchError(null));  
  }

  multiply(tagValue:string,value1Value:number,value2Value:number): Observable<Editor>{
    const url = `${this.calcUrl}/multiply`;
    // Initialize Params Object
    let params = new HttpParams();

    // Begin assigning parameters
    params = params.append('tag', tagValue);
    params = params.append('value1', value1Value.toString());
    params = params.append('value2', value2Value.toString());
    
    

    return this.http.get(url,{params : params}).pipe(map(
      (resp:number) => {
        var res: Editor;
        res = {
          tag: tagValue,
          value1: value1Value,
          value2: value2Value,
          lastOp: "multiply",
          result: resp
        }
        return res;
      }
      ),catchError(null));  
    }

    divide(tagValue:string,value1Value:number,value2Value:number): Observable<Editor>{
      const url = `${this.calcUrl}/divide`;
      // Initialize Params Object
      let params = new HttpParams();
  
      // Begin assigning parameters
      params = params.append('tag', tagValue);
      params = params.append('value1', value1Value.toString());
      params = params.append('value2', value2Value.toString());
      
      
  
      return this.http.get(url,{params : params}).pipe(map(
        (resp:number) => {
          var res: Editor;
          res = {
            tag: tagValue,
            value1: value1Value,
            value2: value2Value,
            lastOp: "divide",
            result: resp
          }
          return res;
        }
        ),catchError(null));  
      }
}
