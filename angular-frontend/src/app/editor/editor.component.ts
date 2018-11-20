import { Component, OnInit } from '@angular/core';
import { Editor } from './editor';
import { CalculateService } from '../calculate.service';
import { Observable, interval } from 'rxjs';
import { History } from './history';
import { HistoryService } from '../history.service';

@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {

  editor: Editor = {
    tag: "default",
    value1: 0.0,
    value2: 0.0,
    lastOp: "",
    result: 0.0
  }

  historyArray: History[] = [{
    record: 0.0,
    tag: "",
    operation: "",
    value1: 0.0,
    value2: 0.0
  }];

  sub:any;

  constructor(private calcService: CalculateService, private historyService: HistoryService) {
    this.sub = interval(5000)
    .subscribe((val) => { 
      this.historyService.getHistory(this.editor.tag).subscribe(respArray => {
        console.log("Result Arr: " + respArray);
        this.historyArray = respArray;
      })
      console.log('called'); 
    });
   }

  ngOnDestroy(){
    this.sub.unsubscribe();
    console.log("Unsubcribe");

  }

  onSelect(op:String): void {
    
    console.log("Executing op " + op)
    if(op == 'add')
    {
      this.calcService.add(this.editor.tag,this.editor.value1,this.editor.value2).subscribe(respEditor => {
        console.log("Result: " + respEditor);
        this.editor = respEditor;
      });      
    }
    if(op == 'subtract')
    {
      this.calcService.subtract(this.editor.tag,this.editor.value1,this.editor.value2).subscribe(respEditor => {
        console.log("Result: " + respEditor);
        this.editor = respEditor;
      });      
    }
    if(op == 'multiply')
    {
      this.calcService.multiply(this.editor.tag,this.editor.value1,this.editor.value2).subscribe(respEditor => {
        console.log("Result: " + respEditor);
        this.editor = respEditor;
      });      
    }
    if(op == 'divide')
    {
      this.calcService.divide(this.editor.tag,this.editor.value1,this.editor.value2).subscribe(respEditor => {
        console.log("Result: " + respEditor);
        this.editor = respEditor;
      });      
    }
  }

  ngOnInit() {
  }

}
