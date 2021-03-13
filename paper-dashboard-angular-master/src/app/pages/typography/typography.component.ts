import { Component , OnInit } from '@angular/core';
import { SampleHttpService } from '../../sample-http.service';
import { bowlers } from '../../bowlers.model';

@Component({
    selector: 'typography-cmp',
    moduleId: module.id,
    templateUrl: 'typography.component.html'
})

export class TypographyComponent{


    constructor(
        private sampleHttpService: SampleHttpService
    ) {}

    bowlersList: bowlers[] = [];

    ngOnInit(){    
        this.sampleHttpService.getBowlerList().subscribe( data => {		
            this.bowlersList = data.data;
            console.log(this.bowlersList);  
        });        
    }


    onSave() {
    }

}
