import { Component, OnInit } from '@angular/core';
import { SampleHttpService } from '../../sample-http.service';
import { SampleModel, svcModel } from '../../sample.model';

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
    custList: SampleModel[] = [];	
    mdlYear = '2020';

    year : string;
    serviceName : string;
    appPackage : string;

    ngOnInit(){    
        this.sampleHttpService.getSampleList(this.mdlYear).subscribe( data => {		
            this.custList = data.data;
            console.log(this.custList);  
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

                this.year = '';
                this.serviceName = '';
                this.appPackage = '';
                this.ngOnInit();
            }
        });
   }




}
