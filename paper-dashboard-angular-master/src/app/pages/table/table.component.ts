import { Component, OnInit } from '@angular/core';
import { SampleHttpService } from '../../sample-http.service';
import { SampleModel } from '../../sample.model';

declare interface TableData {
    headerRow: string[];
    dataRows: string[][];
}

@Component({
    selector: 'table-cmp',
    moduleId: module.id,
    templateUrl: 'table.component.html'
})

export class TableComponent implements OnInit{
    
    constructor(
        private sampleHttpService: SampleHttpService
    ) {}

    SampleList: SampleModel[] = [];
    plcyId = '3';	

    public tableData1: TableData;
    public tableData2: TableData;
    ngOnInit(){
        this.sampleHttpService.getSampleList(this.plcyId).subscribe( data => {		
            this.SampleList = data.data;
            console.log(this.SampleList);  
        });
    }
}
