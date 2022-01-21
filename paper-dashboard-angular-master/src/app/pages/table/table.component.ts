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
    customerList: SampleModel[] = [];
    mdlYear = '2020';

    year : string;
    serviceName : string;
    appPackage : string;

    ngOnInit(){
        this.sampleHttpService.getSampleList().subscribe( data => {
            this.customerList = data.data;
            console.log('test');
            console.log(this.customerList);
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
