import { Component, OnInit } from '@angular/core';
import { SampleHttpService } from '../../sample-http.service';
import { SampleModel, svcModel } from '../../sample.model';

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
    SvcList: svcModel[] = [];
    plcyId = '3';	
    mdlYear = '2020';

    year : string;
    serviceName : string;
    appPackage : string;

    public tableData1: TableData;
    public tableData2: TableData;
    
    ngOnInit(){
    
        this.sampleHttpService.getSvcList(this.mdlYear).subscribe( data => {		
            this.SvcList = data.data;
            console.log(this.SvcList);  
        });
        

    }


    onSave() {
	  
        const saveData = {
            year : this.year,
            serviceName: this.serviceName,
            appPackage : this.appPackage
        }
         
        this.sampleHttpService.saveSvc(saveData).subscribe(response => {
            if (response.stat === 'ok') {
                alert('save');
            }
        });
   }




}
